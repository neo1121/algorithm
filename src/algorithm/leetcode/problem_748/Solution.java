package algorithm.leetcode.problem_748;

import java.util.Arrays;

public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        int[] count = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            char ch = licensePlate.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                count[ch - 'a'] += 1;
            }
        }
        int index = -1;
        for (int j = words.length - 1; j >= 0; j--) {
            int[] copy = count.clone();
            String word = words[j];
            boolean ok = false;
            for (int i = 0; i < word.length(); i++) {
                if (copy[word.charAt(i) - 'a'] > 0) {
                    copy[word.charAt(i) - 'a'] -= 1;
                    if (Arrays.stream(copy).sum() == 0) {
                        ok = true;
                        break;
                    }
                }
            }
            if (ok) {
                if (index == -1 || words[j].length() <= words[index].length()) {
                    index = j;
                }
            }
        }
        return words[index];
    }

    public static void main(String[] args) {
        int a = 10;
        int b = a;
        b -= 5;
        System.out.println(a);
        System.out.println(b);
    }
}
