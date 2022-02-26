package algorithm.leetcode.problem_49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String hash = hash(str);
            List<String> list = map.get(hash);
            if (list == null) {
                list = new ArrayList<>();
                map.put(hash, list);
            }
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    public String hash(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
