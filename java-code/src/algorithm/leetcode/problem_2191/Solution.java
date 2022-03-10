package algorithm.leetcode.problem_2191;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static class MyComparator implements Comparator<Integer> {
        public int[] mapping;
        public HashMap<Integer, Integer> map;

        public MyComparator(int[] mapping) {
            this.mapping = mapping;
            this.map = new HashMap<>();
        }

        public Integer map(Integer num) {
            Integer ans = map.get(num);
            if (ans != null) {
                return ans;
            }
            char[] chars = num.toString().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char) (mapping[chars[i] - '0'] + '0');
            }
            ans = Integer.parseInt(new String(chars));
            map.put(num, ans);
            return ans;
        }

        @Override
        public int compare(Integer t1, Integer t2) {
            t1 = map(t1);
            t2 = map(t2);
            return t1 - t2;
        }
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        list.sort(new MyComparator(mapping));
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
