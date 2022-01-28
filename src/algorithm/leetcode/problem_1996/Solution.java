package algorithm.leetcode.problem_1996;

import java.util.Arrays;

public class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        // 攻击力升序, 防御力降序, 从末尾开始遍历, 避开相同攻击力比较防御力产生的问题
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int ret = 0;
        int max = 0;
        for (int i = properties.length - 1; i >= 0; i--) {
            if (max > properties[i][1]) {
                ret += 1;
            } else if (max < properties[i][1]) {
                max = properties[i][1];
            }
        }
        return ret;
    }
}
