package algorithm.leetcode.problem_79;

public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && process(board, word, 0, i, j, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean process(char[][] board, String word, int index, int i, int j, int m, int n) {
        if (index >= word.length()) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        board[i][j] = '0';
        boolean ans = process(board, word, index + 1, i + 1, j, m, n)
                || process(board, word, index + 1, i - 1, j, m, n)
                || process(board, word, index + 1, i, j + 1, m, n)
                || process(board, word, index + 1, i, j - 1, m, n);
        board[i][j] = word.charAt(index);
        return ans;
    }
}
