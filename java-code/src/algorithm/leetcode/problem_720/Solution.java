package algorithm.leetcode.problem_720;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, (s1, s2) -> {
            int len1 = s1.length();
            int len2 = s2.length();
            if (len1 == len2) {
                char[] chars1 = s1.toCharArray();
                char[] chars2 = s2.toCharArray();
                for (int i = 0; i < len1; i++) {
                    if (chars1[i] != chars2[i]) {
                        return chars2[i] - chars1[i];
                    }
                }
                return 0;
            }
            return len1 - len2;
        });
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        String ans = "";
        for (int i = words.length - 1; i >= 0; i--) {
            String temp = words[i];
            temp = temp.substring(0, temp.length() - 1);
            while (temp.length() > 0) {
                if (!set.contains(temp)) {
                    break;
                }
                temp = temp.substring(0, temp.length() - 1);
            }
            if (temp.length() == 0) {
                ans = words[i];
                break;
            }
        }
        return ans;
    }
}
