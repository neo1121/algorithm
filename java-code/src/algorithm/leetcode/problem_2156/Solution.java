package algorithm.leetcode.problem_2156;

public class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            if (hash(sub, power, modulo) == hashValue) {
                return sub;
            }
        }
        return "";
    }

    public long hash(String s, int power, int modulo) {
        long ret = 0;
        long p = 1;
        for (int i = 0; i < s.length(); i++) {
            ret = (ret + ((s.charAt(i) - 'a' + 1) * p) % modulo) % modulo;
            p = (p * power) % modulo;
        }
        return ret % modulo;
    }
}
