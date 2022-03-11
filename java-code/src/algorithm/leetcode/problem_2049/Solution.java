package algorithm.leetcode.problem_2049;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int countSize(int node, HashMap<Integer, List<Integer>> childrenMap, int[] size) {
        if (size[node] > 0) {
            return size[node];
        }
        List<Integer> childrenList = childrenMap.get(node);
        if (childrenList == null) {
            return 1;
        }
        int ans = 1;
        for (Integer integer : childrenList) {
            int temp = countSize(integer, childrenMap, size);
            size[integer] = temp;
            ans += temp;
        }
        return ans;
    }

    public long countScore(int node, List<Integer> childrenList, int[] size) {
        if (node == 0) {
            int childrenScore = 1;
            for (Integer child : childrenList) {
                childrenScore *= size[child];
            }
            return childrenScore;
        } else if (childrenList != null) {
            int childrenScore = 1;
            for (Integer child : childrenList) {
                childrenScore *= size[child];
            }
            return (long) (size[0] - size[node]) * childrenScore;
        } else {
            return size[0] - 1;
        }
    }

    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        HashMap<Integer, List<Integer>> childrenMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> childrenList = childrenMap.get(parents[i]);
            if (childrenList == null) {
                childrenList = new ArrayList<>();
                childrenMap.put(parents[i], childrenList);
            }
            childrenList.add(i);
        }
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = countSize(i, childrenMap, size);
        }
        long maxScore = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            long score = countScore(i, childrenMap.get(i), size);
            if (score > maxScore) {
                maxScore = score;
                ans = 1;
            } else if (score == maxScore) {
                ans += 1;
            }
        }
        return ans;
    }
}
