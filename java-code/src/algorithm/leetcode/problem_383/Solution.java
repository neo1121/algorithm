package algorithm.leetcode.problem_383;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            count[ransomNote.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a'] -= 1;
        }
        for (int j : count) {
            if (j > 0) {
                return false;
            }
        }
        return true;
    }
}
