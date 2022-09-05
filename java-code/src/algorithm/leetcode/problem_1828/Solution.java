package algorithm.leetcode.problem_1828;

public class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            for (int[] point : points) {
                if ((point[0] - query[0]) * (point[0] - query[0]) + (point[1] - query[1]) * (point[1] - query[1]) <= query[2] * query[2]) {
                    ans[idx] += 1;
                }
            }
            idx += 1;
        }
        return ans;
    }
}
