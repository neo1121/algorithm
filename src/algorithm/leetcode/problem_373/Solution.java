package algorithm.leetcode.problem_373;

import java.util.*;

public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int cur = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 记录数组1中元素在数组2中的索引
        int[] indexs = new int[len1];
        // 记录数组1中与数组2全部匹配过的元素
        int[] used = new int[len1];
        int usedCount = 0;
        List<List<Integer>> ret = new ArrayList<>();
        while (ret.size() < k && usedCount < len1) {
            while (used[cur] == 1) {
                cur = (cur + 1) % len1;
            }
            int next = (cur + 1) % len1;
            while (used[next] == 1) {
                next = (next + 1) % len1;
            }
            int num1 = nums1[cur] + nums2[indexs[cur]];
            int num2 = nums1[next] + nums2[indexs[next]];
            List<Integer> temp = new ArrayList<>();
            if (num1 <= num2) {
                temp.add(nums1[cur]);
                temp.add(nums2[indexs[cur]]);
                ret.add(temp);
                if (++indexs[cur] == len2) {
                    used[cur] = 1;
                    usedCount += 1;
                }
            } else {
                temp.add(nums1[next]);
                temp.add(nums2[indexs[next]]);
                ret.add(temp);
                if (++indexs[next] == len2) {
                    used[next] = 1;
                    usedCount += 1;
                }
            }
        }
        return ret;
    }
}
