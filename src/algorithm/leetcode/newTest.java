package algorithm.leetcode;

public class newTest {
    public static void main(String[] args) {
        int[] n={2,1,5,0,4,6};
        System.out.println(increasingTriplet(n));
    }

    public static boolean increasingTriplet(int[] nums) {
        int min=Integer.MAX_VALUE;
        int secMin=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<=min) min=nums[i];
            else if(min<nums[i]&&nums[i]<=secMin) secMin=nums[i];
            else return true;
        }
        return false;
    }
}
