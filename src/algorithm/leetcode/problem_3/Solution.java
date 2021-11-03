package algorithm.leetcode.problem_3;

import java.util.HashMap;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()<1) return 0;
        if(s.length()<2)return 1;
        int max = 0;
        int beg = 0;
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<chars.length;i++){
            if(map.containsKey(chars[i])){
                beg = Math.max(beg,map.get(chars[i]));
            }
            max = Math.max(max,i-beg+1);
            map.put(chars[i],i+1);
        }
        return max;
    }
}
