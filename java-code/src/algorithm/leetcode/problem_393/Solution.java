package algorithm.leetcode.problem_393;

public class Solution {
    public boolean validUtf8(int[] data) {
        // 1 字节字符 跟 0
        // 0 <= 0xxxxxxx <= 127

        // 2 字节字符 跟 1
        // 192 <= 110xxxxx <= 223

        // 3 字节字符 跟 2
        // 224 <= 1110xxxx <= 239

        // 4 字节字符 跟 3
        // 240 <= 11110xxx <= 247

        // n 位字符后跟字节
        // 128 <= 10xxxxxx <= 191

        for (int i = 0; i < data.length; i++) {
            int num = data[i];
            if (isFollowUnicode(num) || num > 247) {
                return false;
            }
            if (0 <= num && num <= 127) {
                continue;
            }
            int n = i;
            if (192 <= num && num <= 223) {
                n += 1;
            } else if (224 <= num && num <= 239) {
                n += 2;
            } else if (240 <= num && num <= 247) {
                n += 3;
            }
            while (i < n) {
                i += 1;
                if (i >= data.length || !isFollowUnicode(data[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isFollowUnicode(int num) {
        return 128 <= num && num <= 191;
    }
}
