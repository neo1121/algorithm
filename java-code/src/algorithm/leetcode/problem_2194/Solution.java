package algorithm.leetcode.problem_2194;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> cellsInRange(String s) {
        List<String> ans = new ArrayList<>();
        String[] split = s.split(":");
        char startCow = split[0].charAt(0);
        char endCow = split[1].charAt(0);
        char startRow = split[0].charAt(1);
        char endRow = split[1].charAt(1);
        for (int i = startCow; i <= endCow; i++) {
            for (int j = startRow; j <= endRow; j++) {
                ans.add(new String(new char[]{(char) i, (char) j}));
            }
        }
        return ans;
    }
}
