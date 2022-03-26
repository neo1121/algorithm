package algorithm.leetcode.problem_682;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int calPoints(String[] ops) {
        List<Integer> list = new LinkedList<>();
        for (String op : ops) {
            if (op.equals("C")) {
                list.remove(list.size() - 1);
            } else if (op.equals("D")) {
                list.add(list.get(list.size() - 1) * 2);
            } else if (op.equals("+")) {
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
            } else {
                list.add(Integer.parseInt(op));
            }
        }
        int ans = 0;
        for (Integer integer : list) {
            ans += integer;
        }
        return ans;
    }
}
