package algorithm.leetcode.problem_39;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        process(candidates, target, candidates.length - 1, new ArrayList<>());
        return ans;
    }

    public void process(int[] candidates, int target, int index, List<Integer> temp) {
        if (index < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        process(candidates, target, index - 1, temp);
        target -= candidates[index];
        if (target >= 0) {
            temp.add(candidates[index]);
            process(candidates, target, index, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
