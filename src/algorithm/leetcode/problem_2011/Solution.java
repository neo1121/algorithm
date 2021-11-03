package algorithm.leetcode.problem_2011;

public class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String str:operations){
            if(str.charAt(1)=='-') x-=1;
            else x+=1;
        }
        return x;
    }
}
