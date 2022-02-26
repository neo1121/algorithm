package algorithm.leetcode.problem_12;

import java.util.HashMap;

public class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "LC");
        map.put(100, "C");
        map.put(400, "LD");
        map.put(500, "D");
        map.put(900, "DM");
        map.put(1000, "M");
        StringBuilder ret = new StringBuilder();
        int bit = 1;
        while (num > 0) {
            int t = bit;
            bit *= 10;
            int cur = num % bit;
            if (cur < 1) {
                continue;
            }
            num -= cur;
            if (map.containsKey(cur)) {
                ret.insert(0, map.get(cur));
            } else if (cur / t < 4) {
                ret.insert(0, map.get(t).repeat(cur / t));
            } else if (cur / t < 9) {
                ret.insert(0, map.get(t * 5) + map.get(t).repeat((cur / t) - 5));
            }
        }
        return ret.toString();
    }
}
