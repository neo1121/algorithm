package algorithm.leetcode.problem_1220;

import java.util.Arrays;

public class Solution {
    public int countVowelPermutation(int n) {
        long[] letters = {1, 1, 1, 1, 1};
        int len = 1;
        int mod = 1000000007;
        while (len < n) {
            long[] next = new long[5];
            next[0] = (letters[1] + letters[2] + letters[4]) % mod;
            next[1] = (letters[0] + letters[2]) % mod;
            next[2] = (letters[1] + letters[3]) % mod;
            next[3] = letters[2] % mod;
            next[4] = (letters[2] + letters[3]) % mod;
            letters = next;
            len += 1;
        }
        return (int) (Arrays.stream(letters).sum() % (mod));
    }
}
