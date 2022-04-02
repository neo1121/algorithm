package algorithm.leetcode.problem_2215;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> ans0 = new HashSet<>();
        HashSet<Integer> ans1 = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
            if (!set1.contains(i)) {
                ans1.add(i);
            }
        }
        for (int i : nums1) {
            if (!set2.contains(i)) {
                ans0.add(i);
            }
        }
        List<List<Integer>> ans = new LinkedList<>();
        ans.add(new LinkedList<>(ans0));
        ans.add(new LinkedList<>(ans1));
        return ans;
    }
}
