package algorithm.leetcode.problem_1078;

import java.util.ArrayList;

public class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        if (words.length < 3) {
            return new String[]{};
        }
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                ret.add(words[i + 2]);
            }
        }
        return ret.toArray(new String[ret.size()]);
    }
}
