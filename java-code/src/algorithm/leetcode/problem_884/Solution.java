package algorithm.leetcode.problem_884;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        ArrayList<String> ret = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                ret.add(entry.getKey());
            }
        }
        return ret.toArray(new String[ret.size()]);
    }
}
