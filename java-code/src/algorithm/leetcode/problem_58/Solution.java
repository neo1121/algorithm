package algorithm.leetcode.problem_58;

public class Solution {
    public int lengthOfLastWord(String s) {
        String[] strs = s.split("[ ]");
        for (int i = strs.length - 1; i >= 0; i--) {
            if (isWord(strs[i])) return strs[i].length();
        }
        return 0;
    }

    public boolean isWord(String str) {
        str = str.toLowerCase();
        for (char ch : str.toCharArray()) {
            if (ch < 'a' || ch > 'z') return false;
        }
        return true;
    }

    // good
    public int lengthOfLastWord2(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (count != 0 && chars[i] == ' ') break;
            else if (chars[i] != ' ') count += 1;
        }
        return count;
    }
}
