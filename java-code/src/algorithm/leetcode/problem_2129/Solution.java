package algorithm.leetcode.problem_2129;

public class Solution {
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            if (word.length() > 2) {
                if (word.charAt(0) < 'A' || word.charAt(0) > 'Z') {
                    char[] chars = word.toCharArray();
                    chars[0] = (char) (chars[0] - 'a' + 'A');
                    word = new String(chars);
                }
            }
            ret.append(word);
            if (i != words.length - 1) {
                ret.append(" ");
            }
        }
        return ret.toString();
    }
}
