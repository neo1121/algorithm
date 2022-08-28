package algorithm.leetcode.problem_2094;

import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new TreeSet<>();
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    if (digits[i] != 0 && digits[k] % 2 == 0) {
                        set.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                    }
                }
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
