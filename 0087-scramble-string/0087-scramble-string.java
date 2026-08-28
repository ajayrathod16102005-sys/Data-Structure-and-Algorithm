import java.util.*;

class Solution {

    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {

        // Same string
        if (s1.equals(s2)) {
            return true;
        }

        // Already calculated
        String key = s1 + "#" + s2;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // If character frequencies are different,
        // they cannot be scrambled versions.
        int[] count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                memo.put(key, false);
                return false;
            }
        }

        int n = s1.length();

        // Try every possible split
        for (int i = 1; i < n; i++) {

            // Case 1: No swap
            boolean noSwap =
                isScramble(s1.substring(0, i),
                           s2.substring(0, i))
                &&
                isScramble(s1.substring(i),
                           s2.substring(i));

            if (noSwap) {
                memo.put(key, true);
                return true;
            }

            // Case 2: Swap
            boolean swap =
                isScramble(s1.substring(0, i),
                           s2.substring(n - i))
                &&
                isScramble(s1.substring(i),
                           s2.substring(0, n - i));

            if (swap) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }
}