package algorithm.leetcode.problem_689;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    static class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] t1, int[] t2) {
            return t1[1] - t2[1];
        }
    }

    public boolean hasOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new MyComparator());
        int end = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] > end) {
                end = interval[1];
            } else {
                return true;
            }
        }
        return false;
    }

    public int getSum(int[] nums, int[][] intervals) {
        int sum = 0;
        for (int[] interval : intervals) {
            for (int i = interval[0]; i <= interval[1]; i++) {
                sum += nums[i];
            }
        }
        return sum;
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ret = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int len = nums.length - k + 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int l = 0; l < len; l++) {
                    int[][] intervals = new int[3][2];
                    intervals[0] = new int[]{i, i + k - 1};
                    intervals[1] = new int[]{j, j + k - 1};
                    intervals[2] = new int[]{l, l + k - 1};
                    if (hasOverlapIntervals(intervals)) {
                        continue;
                    }
                    int sum = getSum(nums, intervals);
                    if (sum > max) {
                        max = sum;
                        ret = new int[]{i, j, l};
                    } else if (sum == max) {
                        int[] temp = new int[]{i, j, l};
                        Arrays.sort(temp);
                        for (int m = 0; m < ret.length; m++) {
                            if (ret[m] > temp[m]) {
                                ret = temp;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{44373, 10902, 54583, 23982, 31189, 18028, 10447, 32387, 57284, 61499, 48093, 57979, 47480, 26312, 62335, 53637, 4055, 19560, 4208, 62393, 7072, 37542, 19812, 35711, 55461, 16899, 45550, 19301, 5190, 57443, 18711, 34905, 4023, 10431, 9690, 26965, 18236, 45857, 62769, 60437, 7138, 59957, 40155, 30823, 58611, 25709, 30652, 58397, 42, 8199, 22332, 3645, 60973, 50944, 61379, 33402, 11115, 51889, 58276, 46604, 51978, 15636, 62567, 60521, 33383, 33669, 43713, 9304, 15467, 57391, 6099, 31735, 26581, 57868, 7384, 57203, 64825, 50089, 21298, 53160, 40111, 38169, 63041, 42401, 12825, 12365, 29538, 55419, 19122, 18857, 37521, 7328, 5532, 55422, 60920, 40138, 59638, 17313, 43762, 9649, 45725, 40934, 33194, 49171, 17663, 41901, 65157, 53563, 37914, 27740, 47319, 26205, 62322, 11920, 42586, 31817, 3986, 40938, 62862, 63054, 58280, 15101, 44332, 26850, 25732, 44850, 53066, 23564, 15754, 43132, 11287, 21229, 38871, 36316, 50353, 46771, 17264, 61070, 36522, 37914, 56260, 44994, 48868, 32221, 37207, 6703, 17231, 14762, 31900, 51154, 3232, 62798, 14262, 15408, 49826, 63684, 8429, 34507, 19054, 30767, 30019, 59130, 33344, 30461, 57187, 44212, 7465, 14989, 23038, 24672, 58440, 52652, 16636, 50260, 36647, 57975, 19058, 43570, 62997, 19620, 58851, 59853, 30051, 30794, 25111, 7341, 20900, 61163, 62326, 44343, 9742, 34722, 6981, 55058, 11730, 20319, 59715, 3464, 11600, 53653};
        System.out.println(Arrays.toString(new Solution().maxSumOfThreeSubarrays(nums, 3)));
    }
}
