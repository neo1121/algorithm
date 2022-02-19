package algorithm.leetcode.problem_969;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        int max = arr.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] == max) {
                    flip(arr, j);
                    ans.add(j + 1);
                    flip(arr, arr.length - i - 1);
                    ans.add(arr.length - i);
                    break;
                }
            }
            max -= 1;
        }
        return ans;
    }

    public void flip(int[] arr, int k) {
        for (int l = 0; l < k; l++, k--) {
            int temp = arr[l];
            arr[l] = arr[k];
            arr[k] = temp;
        }
    }
}
