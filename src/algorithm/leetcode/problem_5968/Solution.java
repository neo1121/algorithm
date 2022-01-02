package algorithm.leetcode.problem_5968;

public class Solution {
    public int numberOfBeams(String[] bank) {
        int[] count = new int[bank.length];
        for (int i = 0; i < bank.length; i++) {
            String s = bank[i];
            for (int j = 0; j < s.length(); j++) {
                count[i] += Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        int ret = 0;
        for (int i = 0; i < count.length - 1; ) {
            if (count[i] == 0) {
                i += 1;
                continue;
            }
            int next = i + 1;
            while (count[next] == 0) {
                next += 1;
                if (next >= count.length) {
                    return ret;
                }
            }
            ret += count[i] * count[next];
            i = next;
        }
        return ret;
    }
}
