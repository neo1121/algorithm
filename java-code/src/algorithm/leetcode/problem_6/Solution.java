package algorithm.leetcode.problem_6;

import java.util.Arrays;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[] strs = new String[numRows];
        Arrays.fill(strs, "");
        int index = 0;
        boolean f = true;
        for (int i = 0; i < s.length(); i++) {
            strs[index] += s.charAt(i);
            if (f && index == numRows - 1) {
                f = false;
                index -= 1;
            } else if (f) {
                index += 1;
            } else if (index == 0) {
                f = true;
                index += 1;
            } else {
                index -= 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            System.out.println(str);
            sb.append(str);
        }
        return sb.toString();
    }
}
