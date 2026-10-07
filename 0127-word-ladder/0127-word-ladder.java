
import java.util.*;

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Store all dictionary words in a HashSet
        Set<String> wordSet = new HashSet<>(wordList);
        // If endWord is not present, transformation is impossible
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // BFS queue
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        // Number of words in the transformation sequence
        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process all words at the current level
            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                // Try changing every character
                char[] chars = current.toCharArray();

                for (int j = 0; j < chars.length; j++) {

                    char original = chars[j];

                    // Try every lowercase English letter
                    for (char c = 'a'; c <= 'z'; c++) {

                        // No need to replace with the same character
                        if (c == original) {
                            continue;
                        }

                        chars[j] = c;

                        String nextWord = new String(chars);

                        // If we reached endWord
                        if (nextWord.equals(endWord)) {
                            return level + 1;
                        }

                        // If the new word exists in dictionary
                        if (wordSet.contains(nextWord)) {

                            queue.offer(nextWord);

                            // Remove it so we don't visit it again
                            wordSet.remove(nextWord);
                        }
                    }

                    // Restore original character
                    chars[j] = original;
                }
            }

            // Move to next level
            level++;
        }

        // No transformation sequence exists
        return 0;
    }
}
