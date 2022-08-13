package algorithm.leetcode.problem_1282;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            if (size == 0) {
                continue;
            }
            List<Integer> group = new ArrayList<>();
            group.add(i);
            for (int j = i + 1; group.size() < size && j < groupSizes.length; j++) {
                if (groupSizes[j] != size) {
                    continue;
                }
                group.add(j);
                groupSizes[j] = 0;
            }
            groupSizes[i] = 0;
            ans.add(group);
        }
        return ans;
    }
}
