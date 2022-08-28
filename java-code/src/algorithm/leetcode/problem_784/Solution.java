package algorithm.leetcode.problem_784;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        List<String> res = new ArrayList<>();
        process(chars, 0, res);
        return res;
    }

    public void process(char[] chars, int index, List<String> res) {
        if (index == chars.length) {
            res.add(new String(chars));
            return;
        }
        if (chars[index] >= '0' && chars[index] <= '9') {
            process(chars, index + 1, res);
            return;
        }
        chars[index] = Character.toLowerCase(chars[index]);
        process(chars, index + 1, res);
        chars[index] = Character.toUpperCase(chars[index]);
        process(chars, index + 1, res);
    }
}
