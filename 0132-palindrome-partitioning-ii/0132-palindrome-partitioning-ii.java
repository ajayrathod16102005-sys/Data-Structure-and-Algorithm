class Solution {
    public int minCut(String s) {
        int n = s.length();

        // pal[i][j] = true if s[i...j] is a palindrome
        boolean[][] pal = new boolean[n][n];

        // Build palindrome table
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {

                if (s.charAt(start) == s.charAt(end) &&
                    (end - start <= 2 || pal[start + 1][end - 1])) {

                    pal[start][end] = true;
                }
            }
        }

        // dp[i] = minimum cuts needed for s[0...i]
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            // If s[0...i] itself is a palindrome, no cut is needed
            if (pal[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i; // Maximum possible cuts
            }

            // Try every possible palindrome ending at i
            for (int j = 1; j <= i; j++) {
                if (pal[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}