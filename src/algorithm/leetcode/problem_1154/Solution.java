package algorithm.leetcode.problem_1154;

public class Solution {
    public int dayOfYear(String date) {
        String[] split = date.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ret = 0;
        if (month > 2 && (year % 4 == 0 || year % 400 == 0)) {
            ret += 1;
        }
        for (int i = 0; i < month - 1; i++) {
            ret += days[i];
        }
        return ret + day;
    }

}
