package algorithm.leetcode.problem_26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int cur = 0;
        int next = 1;
        while (next < nums.length) {
            while (nums[cur] == nums[next]) {
                next += 1;
                if(next >= nums.length){
                    return cur + 1;
                }
            }
            swap(nums, ++cur, next++);
        }
        return cur + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
