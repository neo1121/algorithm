package algorithm.leetcode.problem_553;

public class Solution {
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i != nums.length - 1) {
                sb.append('/');
                count += 1;
            }
        }
        if (count > 1) {
            sb.insert(sb.indexOf("/") + 1, '(');
            sb.append(')');
        }
        return sb.toString();
    }
}
