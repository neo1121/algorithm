package algorithm.leetcode.problem_373;

import java.util.*;

public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> (nums1[a[0]] + nums2[a[1]])));
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.add(new int[]{i, 0});
        }
        List<List<Integer>> ret = new ArrayList<>();
        while (ret.size() < k && !minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            ret.add(Arrays.asList(nums1[cur[0]], nums2[cur[1]]));
            if (cur[1] + 1 < nums2.length) {
                cur[1] += 1;
                minHeap.add(cur);
            }
        }
        return ret;
    }
}
