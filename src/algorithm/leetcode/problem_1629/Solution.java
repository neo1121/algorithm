package algorithm.leetcode.problem_1629;

public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char curCh = keysPressed.charAt(0);
        int pressTime = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            int temp = releaseTimes[i] - releaseTimes[i - 1];
            if (temp > pressTime) {
                pressTime = temp;
                curCh = keysPressed.charAt(i);
            } else if (temp == pressTime) {
                curCh= (char) Math.max(curCh,keysPressed.charAt(i));
            }
        }
        return curCh;
    }
}
