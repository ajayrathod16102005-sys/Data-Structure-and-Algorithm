import java.util.*;

class Solution {


    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList)
             {

        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        // If endWord is not present, no answer is possible
        if (!wordSet.contains(endWord)) {
            return result;
        }
        // parent.get(word) = all previous words that can reach word
        // through a shortest path.
        Map<String, List<String>> parent = new HashMap<>();

        // Distance of every word from beginWord
        Map<String, Integer> distance = new HashMap<>();

        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        distance.put(beginWord, 0);

        boolean found = false;

        while (!queue.isEmpty() && !found) {

            int size = queue.size();

            // Process one BFS level at a time
            for (int i = 0; i < size; i++) {

                String current = queue.poll();
                int currentDistance = distance.get(current);

                char[] chars = current.toCharArray();

                for (int j = 0; j < chars.length; j++) {

                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == original) {
                            continue;
                        }

                        chars[j] = c;

                        String next = new String(chars);

                        // Word must be in dictionary
                        if (!wordSet.contains(next)) {
                            continue;
                        }

                        // First time visiting this word
                        if (!distance.containsKey(next)) {

                            distance.put(next, currentDistance + 1);
                            queue.offer(next);

                            parent.put(next, new ArrayList<>());
                            parent.get(next).add(current);

                            if (next.equals(endWord)) {
                                found = true;
                            }
                        }

                        // Another shortest path to the same word
                        else if (distance.get(next) == currentDistance + 1) {

                            parent.get(next).add(current);
                        }
                    }

                    chars[j] = original;
                }
            }
        }

        // No path exists
        if (!distance.containsKey(endWord)) {
            return result;
        }

        // Build paths from endWord back to beginWord
        List<String> path = new ArrayList<>();
        path.add(endWord);

        backtrack(endWord, beginWord, parent, path, result);

        return result;
    }

    private void backtrack(
            String current,
            String beginWord,
            Map<String, List<String>> parent,
            List<String> path,
            List<List<String>> result) {

        // Reached beginWord
        if (current.equals(beginWord)) {

            List<String> sequence = new ArrayList<>(path);

            // Currently path is end -> begin
            // Reverse it to get begin -> end
            Collections.reverse(sequence);

            result.add(sequence);
            return;
        }

        // No parents
        if (!parent.containsKey(current)) {
            return;
        }

        // Try every possible parent
        for (String previous : parent.get(current)) {

            path.add(previous);

            backtrack(
                    previous,
                    beginWord,
                    parent,
                    path,
                    result
            );

            path.remove(path.size() - 1);
        }
    }
}