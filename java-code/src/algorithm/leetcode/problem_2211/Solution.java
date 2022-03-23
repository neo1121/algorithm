package algorithm.leetcode.problem_2211;

public class Solution {
    public int countCollisions(String directions) {
        char[] chars = directions.toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (i > 0 && cur == 'L') {
                char pre = chars[i - 1];
                if (pre == 'S') {
                    ans += 1;
                    chars[i] = 'S';
                }
            } else if (cur == 'R') {
                int next = i + 1;
                for (; next < chars.length; next++) {
                    if (chars[next] != cur) {
                        break;
                    }
                }
                if (next == chars.length) {
                    break;
                }
                char nextChar = chars[next];
                if (nextChar == 'L') {
                    ans += 2 + (next - i - 1);
                    chars[next] = 'S';
                } else if (nextChar == 'S') {
                    ans += next - i;
                }
                i = next;
            }
        }
        return ans;
    }
}
