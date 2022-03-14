package algorithm.leetcode.problem_599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> list = new ArrayList<>();
        int minIndexSum = 2000;
        for (int i = 0; i < list2.length; i++) {
            int index = map.getOrDefault(list2[i], 2000);
            if (i + index < minIndexSum) {
                minIndexSum = i + index;
                list.clear();
                list.add(list2[i]);
            } else if (i + index == minIndexSum) {
                list.add(list2[i]);
            }
        }
        return list.toArray(new String[0]);
    }
}
