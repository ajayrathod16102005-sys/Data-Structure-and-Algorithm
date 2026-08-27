class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
        
            // If current index is not reachable
            if (i > farthest) {
                return false;
            }

            // Update the farthest reachable index
            farthest = Math.max(farthest, i + nums[i]);

            // If we can reach or pass the last index
            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}