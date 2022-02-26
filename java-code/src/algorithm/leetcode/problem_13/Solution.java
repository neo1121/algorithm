package algorithm.leetcode.problem_13;

import java.util.HashMap;

public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ret = map.get(s.charAt(0));
        int pre = map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int cur = map.get(s.charAt(i));
            if (cur > pre) {
                ret -= pre * 2;
            }
            ret += cur;
            pre = cur;
        }
        return ret;
    }
}
