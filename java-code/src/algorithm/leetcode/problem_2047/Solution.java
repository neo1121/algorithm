package algorithm.leetcode.problem_2047;

public class Solution {
    public int countValidWords(String sentence) {
        String[] split = sentence.split(" ");
        int ret = 0;
        for (String word : split) {
            if (word.length() > 0 && judge(word)) {
                ret += 1;
            }
        }
        return ret;
    }

    public boolean judge(String word) {
        boolean f = false;
        boolean f2 = false;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (f && !f2) {
                    f2 = true;
                }
                continue;
            }
            if (ch == '-' && i != 0) {
                if (!f) {
                    f = true;
                    continue;
                } else {
                    return false;
                }
            }
            if ((ch == '!' || ch == '.' || ch == ',') && i == word.length() - 1) {
                continue;
            }
            return false;
        }
        return f == f2;
    }
}
