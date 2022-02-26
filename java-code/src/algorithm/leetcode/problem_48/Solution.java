package algorithm.leetcode.problem_48;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void rotate(int[][] matrix) {
        Queue<Integer> queue = new LinkedList<>();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                queue.add(anInt);
            }
        }
        int n = matrix.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                matrix[j][i] = queue.poll();
            }
        }
    }
}
