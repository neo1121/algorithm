package algorithm.leetcode.problem_36;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] arr1 = new int[9][9];
        int[][] arr2 = new int[9][9];
        int[][] arr3 = new int[9][9];
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = board[i][j] - '1';
                if (num < 0 || num > 9) {
                    continue;
                }
                if (arr1[i][num] == 1) {
                    return false;
                } else {
                    arr1[i][num] = 1;
                }
                if (arr2[j][num] == 1) {
                    return false;
                } else {
                    arr2[j][num] = 1;
                }
                int p = (i / 3) * 3 + j / 3;
                if (arr3[p][num] == 1) {
                    return false;
                } else {
                    arr3[p][num] = 1;
                }
            }
        }
        return true;
    }
}
