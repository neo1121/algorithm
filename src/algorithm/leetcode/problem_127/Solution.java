package algorithm.leetcode.problem_127;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    static class Data{
        public String val;
        public int level;

        public Data(String val,int level){
            this.val = val;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Data> queue = new LinkedList<>();
        HashSet<String> usedWord = new HashSet<>();
        queue.add(new Data(beginWord,1));
        usedWord.add(beginWord);
        while (!queue.isEmpty()) {
            Data cur = queue.poll();
            for (String next : wordList) {
                if (!usedWord.contains(next) && changeOnce(cur.val, next)) {
                    if(next.equals(endWord)) return cur.level+1;
                    usedWord.add(next);
                    queue.add(new Data(next,cur.level+1));
                }
            }
        }
        return 0;
    }

    public boolean changeOnce(String wordA, String wordB) {
        int count = 0;
        char[] charsA = wordA.toCharArray();
        char[] charsB = wordB.toCharArray();
        for (int i = 0; i < charsA.length; i++) {
            if (charsA[i] != charsB[i]) count += 1;
        }
        return count == 1;
    }
}
