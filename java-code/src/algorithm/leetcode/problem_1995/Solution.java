package algorithm.leetcode.problem_1995;

public class Solution {
    public int countQuadruplets(int[] nums) {
        int ret = 0;
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                for(int k=j+1;k<nums.length-1;k++){
                    int temp = nums[i]+nums[j]+nums[k];
                    for(int l=k+1;l<nums.length;l++){
                        if(temp==nums[l]){
                            ret+=1;
                        }
                    }
                }
            }
        }
        return ret;
    }
}
