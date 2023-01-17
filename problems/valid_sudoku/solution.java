class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' && !isValid(board, i, j)) return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j) {
        char c = board[i][j];
        for (int k = j + 1; k < board[i].length; k++) {
            if (board[i][k] == c) {
                return false;
            }
        }
        for (int k = i + 1; k < board.length; k++) {
            if (board[k][j] == c) {
                return false;
            }
        }

        int ibox = (i - i % 3);
        int jbox = (j - j % 3);
        for (int k = ibox; k < ibox + 3; k++) {
            for (int l = jbox; l < jbox + 3; l++) {
                if (k != i && l != j && board[k][l] == c) {
                    return false;
                }
            }
        }
        return true;

    }

        /*
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

                c = board[(i / 3) * 3 + (j / 3)][(i % 3) * 3 + (j % 3)];
                if (c != '.') {
                    if (schars[c - '1']) return false;
                    else schars[c - '1'] = true;
                }
            }
        }
        return true;
    }
    */
}