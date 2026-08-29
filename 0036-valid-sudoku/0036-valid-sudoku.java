class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                char ch = board[row][col];

                // Ignore empty cells
                if (ch == '.') {
                    continue;
                }

                int digit = ch - '1';

                // Find the 3x3 box number
                int box = (row / 3) * 3 + (col / 3);

                // Check duplicate
                if (rows[row][digit] ||
                
                    cols[col][digit] ||
                    boxes[box][digit]) {

                    return false;
                }

                // Mark digit as used
                rows[row][digit] = true;
                cols[col][digit] = true;
                boxes[box][digit] = true;
            }
        }

        return true;
    }
}