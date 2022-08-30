package algorithm.leetcode.problem_438;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        char[] charsS = s.toCharArray();
        char[] charsP = p.toCharArray();
        int[] cntS = new int[26];
        int[] cntP = new int[26];

        for (char c : charsP) {
            cntP[c - 'a'] += 1;
        }

        int left = 0;
        int right = 0;

        while (right < charsS.length) {
            cntS[charsS[right] - 'a'] += 1;
            while (cntS[charsS[right] - 'a'] > cntP[charsS[right] - 'a']) {
                cntS[charsS[left] - 'a'] -= 1;
                left += 1;
            }
            if (right - left + 1 == charsP.length) {
                ans.add(left);
            }
            right += 1;
        }
        return ans;
    }
}
