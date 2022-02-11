package algorithm.leetcode.problem_78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        process(nums, 0, new ArrayList<>());
        return ans;
    }

    public void process(int[] nums, int index, List<Integer> temp) {
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            ans.add(new ArrayList<>(temp));
            process(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
