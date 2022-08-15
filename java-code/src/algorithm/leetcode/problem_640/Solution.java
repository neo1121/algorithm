package algorithm.leetcode.problem_640;

public class Solution {
    public String solveEquation(String equation) {
        char[] chars = equation.toCharArray();
        int xNum = 0;
        int constNum = 0;
        int temp = 0;
        boolean add = true;
        boolean isLeft = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'x') {
                int num = 1;
                if (i > 0 && chars[i - 1] <= '9' && chars[i - 1] >= '0') {
                    num *= temp;
                    temp = 0;
                }
                xNum = add ? xNum + num : xNum - num;
            } else if (chars[i] <= '9' && chars[i] >= '0') {
                temp = temp * 10 + (chars[i] - '0');
            } else {
                constNum = !add ? constNum + temp : constNum - temp;
                temp = 0;
                if (chars[i] == '=') {
                    isLeft = false;
                    add = false;
                } else {
                    add = isLeft ? chars[i] == '+' : chars[i] == '-';
                }
            }
        }
        if (temp != 0) {
            constNum = !add ? constNum + temp : constNum - temp;
        }
        // System.out.println(xNum+" "+constNum);
        if (xNum == 0) {
            return constNum == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + constNum / xNum;
    }
}
