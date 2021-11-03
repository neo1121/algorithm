package algorithm.leetcode.problem_547;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        HashMap<Integer,HashSet<Integer>> nodes = new HashMap<>();
        for(int fromVal = 0;fromVal< n; fromVal++){
            HashSet<Integer> fromEdge = nodes.get(fromVal);
            if(fromEdge == null){
                fromEdge = new HashSet<>();
                fromEdge.add(fromVal);
                nodes.put(fromVal,fromEdge);
            }
            for(int toVal = fromVal+1;toVal< n;toVal++){
                HashSet<Integer> toEdge = nodes.get(toVal);
                if(toEdge == null){
                    toEdge = new HashSet<>();
                    toEdge.add(toVal);
                    nodes.put(toVal,toEdge);
                }
                if(isConnected[fromVal][toVal]==1){
                    for(Integer node : toEdge){
                        fromEdge.add(node);
                        nodes.put(node,fromEdge);
                    }
                }
            }
        }
        int count = 0;
        HashSet<Integer> usedNode = new HashSet<>();
        for(Map.Entry<Integer,HashSet<Integer>> entry:nodes.entrySet()){
            if(!usedNode.contains(entry.getKey())){
                count+=1;
                usedNode.addAll(entry.getValue());
            }
        }
        return count;
    }
}
