package algorithm.leetcode.problem_1185;

public class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] val = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] monthDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = day;
        // 非整百年被4整除为闰年
        // 整百年被400整除为闰年
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            monthDays[1] += 1;
        }
        for (int i = 0; i < month - 1; i++) {
            days += monthDays[i];
        }
        for (int i = 1971; i < year; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                days += 366;
            } else {
                days += 365;
            }
        }
        return val[(4 + days) % 7];
    }
}
