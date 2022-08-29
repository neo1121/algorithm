package algorithm.leetcode.problem_394;

import java.util.Stack;

public class Solution {

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        Stack<StringBuilder> sbStack = new Stack<>();
        Stack<Integer> kStack = new Stack<>();
        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                k = k * 10 + chars[i] - '0';
            } else if (chars[i] == '[') {
                kStack.push(k);
                k = 0;
                sbStack.push(sb);
                sb = new StringBuilder();
            } else if (chars[i] == ']') {
                StringBuilder pre = sbStack.pop();
                int tempK = kStack.pop();
                for (int j = 0; j < tempK; j++) {
                    pre.append(sb);
                }
                sb = pre;
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
