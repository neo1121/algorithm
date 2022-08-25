package algorithm.leetcode.problem_658;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();

        int left = binarySearch(arr, 0, arr.length - 1, x);
        int right = left + 1;

        int cnt = 0;

        while (cnt < k) {
            if (left < 0) {
                right += 1;
                cnt += 1;
                continue;
            }
            if (right >= arr.length) {
                left -= 1;
                cnt += 1;
                continue;
            }
            int leftAbs = Math.abs(arr[left] - x);
            int rightAbs = Math.abs(arr[right] - x);
            if (leftAbs <= rightAbs) {
                left -= 1;
                cnt += 1;
                continue;
            }
            right += 1;
            cnt += 1;
        }

        for (int i = left + 1; i < right; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }

    static int binarySearch(int[] arr, int l, int r, int tar) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == tar) {
                return mid;
            } else if (arr[mid] > tar) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (r > 0) {
            return Math.abs(arr[r - 1] - tar) <= Math.abs(arr[r] - tar) ? r - 1 : r;
        }
        return 0;
    }
}
