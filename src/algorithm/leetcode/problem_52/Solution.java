package algorithm.leetcode.problem_52;

public class Solution {

    public int totalNQueens(int n) {
        int[] record = new int[n];
        return process(record, 0, n);
    }

    public int process(int[] record, int row, int n) {
        if (row == n) {
            return 1;
        }
        int res = 0;
        for (int col = 0; col < n; col++) {
            if (isValid(record, row, col)) {
                record[row] = col;
                res += process(record, row + 1, n);
            }
        }
        return res;
    }

    public boolean isValid(int[] record, int row, int col) {
        for (int bef = 0; bef < row; bef++) {
            if (record[bef] == col || Math.abs(row - bef) == Math.abs(col - record[bef]))
                return false;
        }
        return true;
    }

}
