package algorithm.leetcode.problem_167;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] set = new int[2001];
        for (int i = 0; i < numbers.length; i++) {
            int need = target - numbers[i];
            if (set[hash(numbers[i])] > 0) {
                return new int[]{set[hash(numbers[i])], i + 1};
            }
            if (need >= -1000 && need <= 1000) {
                set[hash(need)] = i + 1;
            }
        }
        return new int[]{};
    }

    public int hash(int num) {
        return num + 1000;
    }
}
