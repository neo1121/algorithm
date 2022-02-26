package algorithm.leetcode.problem_22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        process(n, 0, 0, new StringBuilder());
        return ans;
    }

    public void process(int n, int l, int r, StringBuilder temp) {
        if (l > n || r > n) {
            return;
        }
        if (l == n && r == n) {
            ans.add(temp.toString());
            return;
        }
        if (l >= r && l < n) {
            temp.append('(');
            process(n, l + 1, r, temp);
            temp.delete(temp.length() - 1, temp.length());
        }
        if (r < l) {
            temp.append(')');
            process(n, l, r + 1, temp);
            temp.delete(temp.length() - 1, temp.length());
        }
    }
}
