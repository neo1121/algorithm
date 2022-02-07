package algorithm.leetcode.problem_2161;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        Queue<Integer> small = new LinkedList<>();
        Queue<Integer> big = new LinkedList<>();
        Queue<Integer> equal = new LinkedList<>();
        for (int num : nums) {
            if (num < pivot) {
                small.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                big.add(num);
            }
        }
        int index = 0;
        while (!small.isEmpty()) {
            nums[index++] = small.poll();
        }
        while (!equal.isEmpty()) {
            nums[index++] = equal.poll();
        }
        while (!big.isEmpty()) {
            nums[index++] = big.poll();
        }
        return nums;
    }

}
