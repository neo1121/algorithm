package algorithm.leetcode.problem_997;

public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] votes = new int[n + 1];
        int[] voteOut = new int[n + 1];
        boolean f = false;
        int ret = -1;
        for (int[] ints : trust) {
            voteOut[ints[0]] += 1;
            votes[ints[1]] += 1;
        }
        for (int i = 1; i <= n; i++) {
            if (votes[i] == n - 1 && voteOut[i] == 0) {
                if (f) {
                    return -1;
                } else {
                    f = true;
                    ret = i;
                }
            }
        }
        return ret;
    }
}
