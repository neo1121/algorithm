package algorithm.leetcode.problem_1576;

public class Solution {
    private char getFitChar(char ch) {
        return (char) (((ch - 'a' + 1) % 26) + 'a');
    }

    private char getFitChar(char ch1, char ch2) {
        int a = (ch1 - 'a' + 1) % 26;
        int b = ch2 - 'a';
        while (a == b) {
            a = (a + 1) % 26;
        }
        return (char) (a + 'a');
    }

    public String modifyString(String s) {
        if (s.length() == 1) {
            if (s.charAt(0) == '?') {
                return "a";
            }
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && chars[i] == '?') {
                if (chars[i + 1] == '?') {
                    chars[i] = 'a';
                } else {
                    chars[i] = getFitChar(chars[i + 1]);
                }
                continue;
            }
            if (i == chars.length - 1) {
                if (chars[i] == '?') {
                    chars[i] = getFitChar(chars[i - 1]);
                }
                break;
            }
            if (chars[i] == '?') {
                if (chars[i + 1] == '?') {
                    chars[i] = getFitChar(chars[i - 1]);
                } else {
                    chars[i] = getFitChar(chars[i - 1], chars[i + 1]);
                }
            }
        }
        return new String(chars);
    }
}
