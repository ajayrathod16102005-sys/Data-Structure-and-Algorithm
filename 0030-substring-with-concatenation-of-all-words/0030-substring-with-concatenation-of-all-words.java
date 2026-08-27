import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {



        List<Integer> result = new ArrayList<>();

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) {
            return result;
        }

        // Frequency of each word in words
        Map<String, Integer> wordFreq = new HashMap<>();

        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        // Try every possible starting offset
        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int right = offset;
            int count = 0;

            Map<String, Integer> window = new HashMap<>();

            while (right + wordLen <= s.length()) {

                // Take next word from s
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                // If word is not in words
                if (!wordFreq.containsKey(word)) {
                    window.clear();
                    count = 0;
                    left = right;
                    continue;
                }

                // Add word to current window
                window.put(word, window.getOrDefault(word, 0) + 1);
                count++;

                // Too many occurrences of this word
                while (window.get(word) > wordFreq.get(word)) {

                    String leftWord = s.substring(left, left + wordLen);

                    window.put(leftWord, window.get(leftWord) - 1);

                    left += wordLen;
                    count--;
                }

                // All words are present
                if (count == wordCount) {
                    result.add(left);

                    // Move left forward to search for another answer
                    String leftWord = s.substring(left, left + wordLen);

                    window.put(leftWord, window.get(leftWord) - 1);

                    left += wordLen;
                    count--;
                }
            }
        }

        return result;
    }
}