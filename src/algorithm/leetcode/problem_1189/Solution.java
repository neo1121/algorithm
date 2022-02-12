package algorithm.leetcode.problem_1189;

public class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        char[] chars = text.toCharArray();
        for (char aChar : chars) {
            count[aChar - 'a'] += 1;
        }
        count['l' - 'a'] /= 2;
        count['o' - 'a'] /= 2;
        int ans = count['b' - 'a'];
        ans = Math.min(ans, count['a' - 'a']);
        ans = Math.min(ans, count['l' - 'a']);
        ans = Math.min(ans, count['o' - 'a']);
        ans = Math.min(ans, count['n' - 'a']);
        return ans;
    }
}
