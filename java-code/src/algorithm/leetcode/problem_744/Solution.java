package algorithm.leetcode.problem_744;

public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int index = binarySearch(letters, 0, letters.length - 1, target);
        return index == -1 ? letters[0] : letters[index];
    }

    public int binarySearch(char[] letters, int l, int r, char target) {
        if (l > r) {
            return -1;
        }
        int m = l + (r - l) / 2;
        if (letters[m] <= target) {
            return binarySearch(letters, m + 1, r, target);
        } else {
            int t = binarySearch(letters, l, m - 1, target);
            return t == -1 ? m : t;
        }
    }
}
