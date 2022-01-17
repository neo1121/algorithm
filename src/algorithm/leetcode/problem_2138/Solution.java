package algorithm.leetcode.problem_2138;

import java.util.Arrays;

public class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len = s.length() / k;
        if (s.length() % k > 0) {
            len += 1;
        }
        String[] ret = new String[len];
        for (int i = 0, index = 0; i < s.length(); i += k, index++) {
            if (i + k > s.length()) {
                ret[index] = s.substring(i);
            } else {
                ret[index] = s.substring(i, i + k);
            }
        }
        System.out.println(Arrays.toString(ret));
        if (ret[len - 1].length() < k) {
            ret[len - 1] += (fill + "").repeat(k - ret[len - 1].length());
        }
        return ret;
    }
}
