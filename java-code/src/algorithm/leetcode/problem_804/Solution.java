package algorithm.leetcode.problem_804;

import java.util.HashSet;

public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        int ans = 0;
        HashSet<String> set = new HashSet<>();
        String[] t = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(t[word.charAt(i) - 'a']);
            }
            if (!set.contains(sb.toString())) {
                ans += 1;
                set.add(sb.toString());
            }
        }
        return ans;
    }
}
