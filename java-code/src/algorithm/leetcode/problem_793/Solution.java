package algorithm.leetcode.problem_793;

public class Solution {
    public int preimageSizeFZF(int k) {
        long l = 0;
        long r = Long.MAX_VALUE;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long zeros = trailingZeroes(mid);
            if (zeros == k) {
                break;
            } else if (zeros > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (l > r) {
            return 0;
        }

        return 5;
    }

    long trailingZeroes(long n) {
        long cnt = 0;
        while (n > 0) {
            n /= 5;
            cnt += n;
        }
        return cnt;
    }
}
