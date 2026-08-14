class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;

            // Count how many numbers have 1 at bit i
            for (int num : nums) {
                if ((num & (1 << i)) != 0) {
                    count++;
                }
            }

            // If remainder is 1, this bit belongs to the answer
            if (count % 3 != 0) {
                result = result | (1 << i);
            }
        }

        return result;
    }
}