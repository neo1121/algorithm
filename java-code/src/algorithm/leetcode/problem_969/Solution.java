package algorithm.leetcode.problem_969;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        for (int i = arr.length; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] == i) {
                    if(j > 0){
                        flip(arr, j);
                        ans.add(j + 1);
                    }
                    flip(arr, i - 1);
                    ans.add(i);
                    break;
                }
            }
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
