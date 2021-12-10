package algorithm.leetcode.problem_17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() < 1) {
            return res;
        }
        String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        process(digits.toCharArray(), 0, map, sb);
        return res;
    }

    public void process(char[] digits, int index, String[] map, StringBuilder combo) {
        if (index == digits.length) {
            res.add(combo.toString());
            return;
        }
        int chIndex = digits[index] - '2';
        char[] chars = map[chIndex].toCharArray();
        for (char aChar : chars) {
            combo.append(aChar);
            process(digits, index + 1, map, combo);
            combo.deleteCharAt(combo.length() - 1);
        }
    }
}
