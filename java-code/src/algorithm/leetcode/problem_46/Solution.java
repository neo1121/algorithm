package algorithm.leetcode.problem_46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        process(nums, 0, res);
        return res;
    }

    public void process(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            process(nums, index + 1, res);
            swap(nums, i, index);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
