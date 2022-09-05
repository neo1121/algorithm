package algorithm.leetcode.problem_2391;

public class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int[] costTime = new int[garbage.length];
        for (int i = 1; i < garbage.length; i++) {
            costTime[i] = costTime[i - 1] + travel[i - 1];
        }

        int ans = 0;

        boolean M = false;
        boolean P = false;
        boolean G = false;

        for (int i = garbage.length - 1; i >= 0; i--) {
            String s = garbage[i];
            ans += s.length();
            if (!M && s.indexOf('M') != -1) {
                M = true;
                ans += costTime[i];
            }
            if (!P && s.indexOf('P') != -1) {
                P = true;
                ans += costTime[i];
            }
            if (!G && s.indexOf('G') != -1) {
                G = true;
                ans += costTime[i];
            }
        }

        return ans;
    }
}
