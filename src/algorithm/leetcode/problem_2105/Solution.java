package algorithm.leetcode.problem_2105;

public class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        if (plants.length == 1) {
            if (capacityA >= capacityB) {
                if (capacityA < plants[0]) {
                    return 1;
                }
            } else if (capacityB < plants[0]) {
                return 1;
            }
            return 0;
        }
        int count = 0;
        int curA = capacityA;
        int curB = capacityB;
        boolean flag = plants.length % 2 == 1;
        for (int i = 0, j = plants.length - 1; j >= i && i < plants.length; i++, j--) {
            curA -= plants[i];
            curB -= plants[j];
            if (flag && i + 1 == j - 1) {
                if (curA >= curB) {
                    if (curA < plants[i + 1]) {
                        count += 1;
                    }
                } else if (curB < plants[j - 1]) {
                    count += 1;
                }
                break;
            }
            if (!flag && i + 1 == j) {
                break;
            }
            if (curA < plants[i + 1]) {
                count += 1;
                curA = capacityA;
            }
            if (curB < plants[j - 1]) {
                count += 1;
                curB = capacityB;
            }
        }
        return count;
    }
}
