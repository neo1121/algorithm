package algorithm.leetcode.problem_1859;

public class Solution {
    public String sortSentence(String s) {
        String[] strings = new String[10];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - '0';
            if (index < 1 || index > 9) {
                continue;
            }
            strings[index] = s.substring(0, i);
            if (i == s.length() - 1) {
                break;
            }
            s = s.substring(i + 2);
            i = 0;
        }
        StringBuilder ret = new StringBuilder();
        for (int i = 1; i < strings.length; i++) {
            if (strings[i] == null) {
                continue;
            }
            ret.append(strings[i]).append(" ");
        }
        ret.deleteCharAt(ret.length() - 1);
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sortSentence("is2 sentence4 This1 a3"));
    }
}
