package algorithm.leetcode.problem_1405;

import java.util.*;

public class Solution {
    static class Record {
        int amount;
        char ch;

        public Record(int amount, char ch) {
            this.amount = amount;
            this.ch = ch;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        Record[] records = new Record[]{new Record(a, 'a'), new Record(b, 'b'), new Record(c, 'c')};
        int sum = a + b + c;
        int[] amounts = new int[3];
        StringBuilder ans = new StringBuilder();
        char pre = ' ';
        for (int i = 0; i < sum; i++) {
            Arrays.sort(records, (o1, o2) -> {
                if (o1.amount == o2.amount) {
                    return -1;
                }
                return o1.amount - o2.amount;
            });
            int idx = -1;
            for (int j = 2; j >= 0; j--) {
                Record record = records[j];
                if (amounts[record.ch - 'a'] < 2 && record.amount > 0) {
                    idx = j;
                    break;
                }
            }
            if (idx == -1) {
                return ans.toString();
            }
            char cur = records[idx].ch;
            if (cur != pre) {
                Arrays.fill(amounts, 0);
            }
            amounts[cur - 'a'] += 1;
            ans.append(cur);
            pre = cur;
            records[idx].amount -= 1;
        }
        return ans.toString();
    }
}
