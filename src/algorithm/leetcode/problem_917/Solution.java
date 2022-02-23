package algorithm.leetcode.problem_917;

public class Solution {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; ) {
            if ((chars[i] < 'a' || chars[i] > 'z') && (chars[i] < 'A' || chars[i] > 'Z')) {
                i++;
            } else if ((chars[j] < 'a' || chars[j] > 'z') && (chars[j] < 'A' || chars[j] > 'Z')) {
                j--;
            } else {
                swap(chars, i++, j--);
            }
        }
        return new String(chars);
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
