package algorithm.leetcode.problem_647;

import java.util.HashMap;

public class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        HashMap<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subStr = s.substring(i, j);
                Boolean ok = map.get(subStr);
                if (ok == null) {
                    ok = isPalindrome(subStr);
                    map.put(subStr, ok);
                }
                if (ok) {
                    ans += 1;
                }
            }
        }
        return ans;
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.print((char) ((int) (Math.random() * 26) + 'a'));
        }
    }
}
