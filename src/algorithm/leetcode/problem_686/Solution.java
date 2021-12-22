package algorithm.leetcode.problem_686;

public class Solution {
    public int repeatedStringMatch(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            int ret = process(a, b, i);
            if (ret != -1) {
                return ret;
            }
        }
        return -1;
    }

    public int process(String a, String b, int from) {
        int aIndex = a.indexOf(b.charAt(0), from);
        if (aIndex == -1) {
            return -1;
        }
        int aLen = a.length();
        int ret = 0;
        for (int bIndex = 0; bIndex < b.length(); bIndex++) {
            if (a.charAt(aIndex) != b.charAt(bIndex)) {
                return -1;
            }
            aIndex += 1;
            if (aIndex == aLen) {
                aIndex %= aLen;
                ret += 1;
            }
        }
        if (aIndex != 0) {
            ret += 1;
        }
        return ret;
    }
}
