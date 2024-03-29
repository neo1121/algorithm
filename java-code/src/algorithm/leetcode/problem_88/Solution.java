package algorithm.leetcode.problem_88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // points to current position
        int i = 0;
        // points to the leftmost side of nums1
        int p1 = 0;
        // points to the leftmost side of nums2
        int p2 = 0;
        int[] help = new int[nums1.length];
        while (p1 < m && p2 < n) {
            help[i++] = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        }
        while (p1 < m){
            help[i++] = nums1[p1++];
        }
        while (p2 < n){
            help[i++] = nums2[p2++];
        }
        for (i = 0; i< nums1.length; i++){
            nums1[i] = help[i];
        }
    }
}
