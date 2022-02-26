package algorithm.leetcode.problem_507;

public class Solution {
    public boolean checkPerfectNumber(int num) {
        int[] ret = new int[]{6, 28, 496, 8128, 33550336};
        for (int i : ret) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // 6,28,496,8128,33550336,
        for (int i = 2; i <= 100000000; i++) {
            int sum = 1;
            int j = 2;
            while (j * j <= i) {
                if (i % j == 0) {
                    sum += j;
                    if (j * j != i) {
                        sum += i / j;
                    }
                }
                j += 1;
            }
            if (sum == i) {
                System.out.printf("%d,", i);
            }
        }
    }
}
