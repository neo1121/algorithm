package algorithm.leetcode.problem_684;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    // kruskal algorithm
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, HashSet<Integer>> mapSet = new HashMap<>();
        for(int[] node:edges){
            int fromVal = node[0];
            int toVal = node[1];
            HashSet<Integer> fromSet = mapSet.get(fromVal);
            HashSet<Integer> toSet = mapSet.get(toVal);
            if(fromSet==null) {
                fromSet = new HashSet<>();
                fromSet.add(fromVal);
                mapSet.put(fromVal,fromSet);
            }
            if(toSet==null) {
                toSet = new HashSet<>();
                toSet.add(toVal);
                mapSet.put(toVal,toSet);
            }
            if(fromSet == toSet) return node;
            for(Integer cur : toSet){
                fromSet.add(cur);
                mapSet.put(cur,fromSet);
            }
        }
        return null;
    }
}
