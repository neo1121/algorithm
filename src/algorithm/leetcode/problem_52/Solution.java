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

    // 位运算加速
    public int process2(int limit, int colLimit, int leftLimit, int rightLimit) {
        // 没有位置可以摆
        if (limit == colLimit) {
            return 1;
        }
        int res = 0;
        // 当前行限制
        int rowLimit = colLimit | leftLimit | rightLimit;
        // 当前行可以摆的位置
        int availablePos = limit & ~rowLimit;
        while (availablePos != 0) {
            // 当前行最右边的可用位置
            int pos = availablePos & (~availablePos + 1);
            availablePos -= pos;
            // 最右边可用位置的情况
            res += process2(limit, colLimit | pos,
                    (leftLimit | pos) << 1,
                    (rightLimit | pos) >>> 1);
        }
        return res;
    }

    public int totalNQueens2(int n) {
        if (n > 32 || n < 1) {
            // 不能超过32皇后
            return 0;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

}
