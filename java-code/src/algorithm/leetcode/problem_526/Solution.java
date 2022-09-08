package algorithm.leetcode.problem_526;

public class Solution {
    int[] used;
    int n;
    int ans;

    public int countArrangement(int n) {
        this.used = new int[n + 1];
        this.n = n;
        this.ans = 0;
        dfs(0);
        return this.ans;
    }

    public void dfs(int index) {
        if (index == n) {
            ans += 1;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i] == 1) {
                continue;
            }
            if (i % (index + 1) != 0 && (index + 1) % i != 0) {
                continue;
            }
            used[i] = 1;
            dfs(index + 1);
            used[i] = 0;
        }
    }
}
