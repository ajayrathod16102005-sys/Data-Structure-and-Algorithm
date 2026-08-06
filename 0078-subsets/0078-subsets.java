class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> current) {

        // Every current subset is valid
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            current.add(nums[i]);                  // Choose

            backtrack(i + 1, nums, current);       // Explore

            current.remove(current.size() - 1);    // Backtrack
        }
    }
}