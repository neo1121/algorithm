package algorithm.codinginterviews.problem_38;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {

    public String[] permutation(String s) {
        char[] str = s.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        process(str, 0, res);
        return res.toArray(String[]::new);
    }

    public void process(char[] str, int index, ArrayList<String> res) {
        if (index == str.length) {
            res.add(new String(str));
            return;
        }
        HashSet<Character> usedChar = new HashSet<>();
        for (int i = index; i < str.length; i++) {
            if (!usedChar.contains(str[i])) {
                usedChar.add(str[i]);
                swap(str, index, i);
                process(str, index + 1, res);
                swap(str, index, i);
            }
        }
    }

    public void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
