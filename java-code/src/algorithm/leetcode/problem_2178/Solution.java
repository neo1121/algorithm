package algorithm.leetcode.problem_2178;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    List<Long> ans;
    boolean f = false;

    public List<Long> maximumEvenSplit(long finalSum) {
        ans = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return ans;
        }
        process(finalSum, 2, new Stack<>());
        return ans;
    }

    public void process(long finalSum, long beg, Stack<Long> temp) {
        if (f) {
            return;
        }
        if (finalSum == 0) {
            ans = new ArrayList<>(temp);
            f = true;
            return;
        }
        if (finalSum < 0 || beg > finalSum) {
            return;
        }
        temp.push(beg);
        process(finalSum - beg, beg + 2, temp);
        temp.pop();
        process(finalSum, beg + 2, temp);
    }
}
