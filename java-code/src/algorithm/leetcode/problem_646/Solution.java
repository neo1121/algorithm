package algorithm.leetcode.problem_646;

import java.util.Arrays;

public class Solution {
    public int findLongestChain(int[][] pairs) {
        int ans = 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int b = -10000;
        for(int[] pair : pairs) {
            if(pair[0] <= b) {
                continue;
            }
            b = pair[1];
            ans += 1;
        }
        return ans;
    }
}
