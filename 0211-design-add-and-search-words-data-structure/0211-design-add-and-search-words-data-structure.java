class WordDictionary {

    // Trie Node
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Add a word to the Trie
    public void addWord(String word) {

        TrieNode current = root;

        for (char c : word.toCharArray()) {

            int index = c - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEnd = true;
    }

    // Search a word
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int index) {

        // Reached the end of the word
        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        // Normal character
        if (c != '.') {

            int childIndex = c - 'a';

            if (node.children[childIndex] == null) {
                return false;
            }

            return dfs(node.children[childIndex], word, index + 1);
        }

        // '.' can match any character
        for (int i = 0; i < 26; i++) {

            if (node.children[i] != null) {

                if (dfs(node.children[i], word, index + 1)) {
                    return true;
                }
            }
        
        
        }

        return false;
    }
}