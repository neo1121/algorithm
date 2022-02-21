package algorithm.leetcode.problem_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int next1 = 1000000;
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (nums[i] == next1) {
                continue;
            } else {
                next1 = nums[i];
            }
            int next = 1000000;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[j] == next) {
                    continue;
                } else {
                    next = nums[j];
                }
                int tar = 0 - nums[i] - nums[j];
                for (int k = j + 1; k < nums.length && nums[k] <= tar; k++) {
                    if (nums[k] == tar) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(tar);
                        ans.add(temp);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
