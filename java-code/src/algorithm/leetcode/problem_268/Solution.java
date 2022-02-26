package algorithm.leetcode.problem_268;

public class Solution {

    public int missingNumber(int[] nums) {
        int ret = 0;
        for(int i = 0;i<nums.length;i++){
            ret ^= (i^nums[i]);
        }
        return ret^nums.length;
    }

    public int missingNumber2(int[] nums) {
        int[] arr = new int[nums.length+1];
        for(int num:nums){
            arr[num] = 1;
        }
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==0)return i;
        }
        return 0;
    }
}
