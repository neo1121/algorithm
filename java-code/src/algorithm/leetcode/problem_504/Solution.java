package algorithm.leetcode.problem_504;

public class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int temp = Math.abs(num);
        while (temp > 0) {
            sb.insert(0, temp % 7);
            temp /= 7;
        }
        if (num < 0) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }
}
