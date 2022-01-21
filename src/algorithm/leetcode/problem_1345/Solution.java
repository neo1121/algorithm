package algorithm.leetcode.problem_1345;

import java.util.*;

public class Solution {
    public int minJumps(int[] arr) {
        int[] used = new int[50001];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> list = map.get(arr[i]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(arr[i], list);
            }
            list.add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        used[0] = 1;
        HashMap<Integer, Integer> stepMap = new HashMap<>();
        stepMap.put(0, 0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curStep = stepMap.get(cur);
            if (cur == arr.length - 1) {
                return curStep;
            }
            if (cur - 1 > 0 && used[cur - 1] == 0) {
                queue.add(cur - 1);
                used[cur - 1] = 1;
                stepMap.put(cur - 1, curStep + 1);
            }
            if (cur + 1 < arr.length && used[cur + 1] == 0) {
                if (cur + 1 == arr.length) {
                    return curStep + 1;
                }
                queue.add(cur + 1);
                used[cur + 1] = 1;
                stepMap.put(cur + 1, curStep + 1);
            }
            ArrayList<Integer> list = map.get(arr[cur]);
            if (list != null) {
                map.remove(arr[cur]);
                for (Integer index : list) {
                    if (index == arr.length) {
                        return curStep + 1;
                    }
                    if (used[index] == 1) {
                        continue;
                    }
                    queue.add(index);
                    used[index] = 1;
                    stepMap.put(index, curStep + 1);
                }
            }
        }
        return 0;
    }
}
