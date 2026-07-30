import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int maxLength = 0;

        while (right < s.length()) {

            char ch = s.charAt(right);

            // If character is not duplicate
            if (!set.contains(ch)) {

                set.add(ch);

                maxLength = Math.max(maxLength, right - left + 1);

                right++;
            }

            // If duplicate character found
            else {

                set.remove(s.charAt(left));

                left++;
            }
        }

        return maxLength;
    }
}