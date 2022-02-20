package algorithm.leetcode.problem_838;

public class Solution {
    public String pushDominoes(String dominoes) {
        char[] chars = dominoes.toCharArray();
        int record = -1;
        for (int i = 0; i < chars.length; i++) {
            char curCh = chars[i];
            if (curCh == '.') {
                if (i == chars.length - 1 && record != -1 && chars[record] == 'R') {
                    for (int j = record + 1; j < chars.length; j++) {
                        chars[j] = 'R';
                    }
                }
                continue;
            }
            if (record == -1) {
                if (curCh == 'L') {
                    for (int j = 0; j < i; j++) {
                        chars[j] = 'L';
                    }
                }
            } else if (chars[record] == 'R' && curCh == 'L') {
                int temp = i - 1;
                record += 1;
                while (record < temp) {
                    chars[record++] = 'R';
                    chars[temp--] = 'L';
                }
            } else if (chars[record] == curCh) {
                for (int j = record + 1; j < i; j++) {
                    chars[j] = curCh;
                }
            }
            record = i;
        }
        return new String(chars);
    }
}
