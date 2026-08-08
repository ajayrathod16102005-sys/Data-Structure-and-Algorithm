class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();

        // dp[i] = number of ways to decode first i characters
        int[] dp = new int[n + 1];

        // Empty string has 1 way
        dp[0] = 1;

        // If first character is '0', it cannot be decoded
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;

        for (int i = 2; i <= n; i++) {

            // Take one digit
            char one = s.charAt(i - 1);

            if (one >= '1' && one <= '9') {
                dp[i] += dp[i - 1];
            }

            // Take two digits
            int two = Integer.parseInt(s.substring(i - 2, i));

            if (two >= 10 && two <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}