package algorithm.leetcode.problem_306;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        for (int i = 1; i < num.length(); i++) {
            for (int j = i + 1; j <= num.length(); j++) {
                String str = countStr(num.substring(0, i), num.substring(i, j), num.length());
                if (num.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String countStr(String first, String second, int length) {
        if ((first.length() > 1 && first.charAt(0) == '0') ||
                (second.length() > 1 && second.charAt(0) == '0')) {
            return null;
        }
        StringBuilder str = new StringBuilder(first + second);
        if (str.length() == length) {
            return null;
        }
        while (str.length() < length) {
            String third = add(first, second);
            str.append(third);
            first = second;
            second = third;
        }
        return str.length() == length ? str.toString() : null;
    }

    public String add(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int index = b.length() - 1;
        int diff = a.length() - b.length();
        char[] aBits = a.toCharArray();
        char[] bBits = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int bit = 0;
        for (; index >= 0; index--) {
            int ret = aBits[index + diff] - '0' + bBits[index] - '0' + bit;
            sb.insert(0, ret % 10);
            bit = ret / 10;
        }
        for (diff -= 1; diff >= 0; diff--) {
            int ret = aBits[diff] - '0' + bit;
            sb.insert(0, ret % 10);
            bit = ret / 10;
        }
        if (bit != 0) {
            sb.insert(0, bit);
        }
        return (sb.length() > 1 && sb.charAt(0) == '0') ? sb.substring(1) : sb.toString();
    }
}
