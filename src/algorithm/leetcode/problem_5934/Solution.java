package algorithm.leetcode.problem_5934;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        System.out.println(Arrays.toString(sortedNums));
        HashSet<Integer> set = new HashSet<>();
        for (int i = sortedNums.length - 1; i >= sortedNums.length - k; i--) {
            set.add(sortedNums[i]);
        }
        System.out.println(set);
        int[] ret = new int[k];
        int index = 0;
        int pos = sortedNums.length - k;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == sortedNums[pos]) {
                ret[index++] = nums[i];
                pos += 1;
                if (index >= k) {
                    break;
                }
            }
        }
        return ret;
    }
}
