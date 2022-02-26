package algorithm.leetcode.problem_2099;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = sortedNums.length - 1; i >= sortedNums.length - k; i--) {
            int count = map.getOrDefault(sortedNums[i], 0);
            map.put(sortedNums[i], count + 1);
        }
        int[] ret = new int[k];
        int index = 0;
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                map.put(num, count - 1);
                ret[index++] = num;
                if(index>=k){
                    break;
                }
            }
        }
        return ret;
    }
}
