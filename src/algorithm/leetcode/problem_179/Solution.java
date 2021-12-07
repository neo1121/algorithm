package algorithm.leetcode.problem_179;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    static class myComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer t1, Integer t2) {
            if (t1.equals(t2)) {
                return 0;
            }
            String s1 = t1.toString();
            String s2 = t2.toString();
            int index1 = 0;
            int index2 = 0;
            while (s1.charAt(index1) == s2.charAt(index2)) {
                index1 = (index1 + 1) % s1.length();
                index2 = (index2 + 1) % s2.length();
                if (index1 == 0 && index2 == 0) {
                    return 0;
                }
            }
            return s2.charAt(index2) - s1.charAt(index1);
        }
    }

    public String largestNumber(int[] nums) {
        boolean isAllZero = true;
        for (int num : nums) {
            if (num != 0) {
                isAllZero = false;
                break;
            }
        }
        if (isAllZero) {
            return "0";
        }
        Integer[] boxedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedNums, new myComparator());
        StringBuilder sb = new StringBuilder();
        for (Integer boxedNum : boxedNums) {
            sb.append(boxedNum);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3, 43, 48, 94, 85, 33, 64, 32, 63, 66};
        Arrays.sort(nums, new myComparator());
        System.out.println(Arrays.toString(nums));
    }
}
