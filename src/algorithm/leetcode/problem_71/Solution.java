package algorithm.leetcode.problem_71;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : paths) {
            if (s.equals("") || s.equals(".")) {
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder ret = new StringBuilder(stack.pop());
        while (!stack.isEmpty()) {
            ret.insert(0, stack.pop() + "/");
        }
        ret.insert(0, "/");
        return ret.toString();
    }
}
