class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            boolean[] hchars = new boolean[9];
            boolean[] vchars = new boolean[9];
            boolean[] schars = new boolean[9];
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (hchars[c - '1']) return false;
                    else hchars[c - '1'] = true;
                }
                c = board[j][i];
                if (c != '.') {
                    if (vchars[c - '1']) return false;
                    else vchars[c - '1'] = true;
                }

                c = board[(i / 3) * 3 + (j / 3)][(i * 3) % 9 + (j % 3)];
                if (c != '.') {
                    if (schars[c - '1']) return false;
                    else schars[c - '1'] = true;
                }
            }
        }
        return true;
    }
}