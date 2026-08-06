class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current) {

        // Base case
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);              // Choose
            backtrack(i + 1, n, k, current); // Explore
            current.remove(current.size() - 1); // Unchoose (Backtrack)
        }
    }
}