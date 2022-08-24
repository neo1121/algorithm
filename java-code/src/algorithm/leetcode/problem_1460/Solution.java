package algorithm.leetcode.problem_1460;

public class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n = target.length;
        int[] cnt = new int[1001];
        for (int i = 0; i < n; i++) {
            cnt[target[i]] += 1;
        }
        for (int i = 0; i < n; i++) {
            cnt[arr[i]] -= 1;
            if (cnt[arr[i]] < 0) {
                return false;
            }
        }
        return true;
    }
}
