package algorithm.leetcode.problem_2022;

public class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[][]{};
        }
        int[][] ret = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            ret[i / n][i % n] = original[i];
        }
        return ret;
    }
}
