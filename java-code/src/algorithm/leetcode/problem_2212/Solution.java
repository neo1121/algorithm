package algorithm.leetcode.problem_2212;

public class Solution {
    public int[] bobArrows;
    public int[] ans;
    public int maxScore;

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        bobArrows = new int[12];
        ans = new int[12];
        maxScore = 0;
        process(numArrows, aliceArrows, 0, 0);
        return ans;
    }

    public void process(int restArrows, int[] aliceArrows, int index, int curScore) {
        if (index == aliceArrows.length) {
            if (curScore > maxScore) {
                if (restArrows > 0) {
                    bobArrows[11] += restArrows;
                }
                maxScore = curScore;
                ans = bobArrows.clone();
            }
            return;
        }
        if (restArrows > aliceArrows[index]) {
            bobArrows[index] = aliceArrows[index] + 1;
            process(restArrows - aliceArrows[index] - 1, aliceArrows, index + 1, curScore + index);
        }
        bobArrows[index] = 0;
        process(restArrows, aliceArrows, index + 1, curScore);
    }
}
