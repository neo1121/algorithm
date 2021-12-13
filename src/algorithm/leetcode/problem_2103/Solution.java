package algorithm.leetcode.problem_2103;

public class Solution {
    public int countPoints(String rings) {
        if (rings.length() < 6) {
            return 0;
        }
        char[] chars = rings.toCharArray();
        String[] gans = new String[]{"", "", "", "", "", "", "", "", "", ""};
        int count = 0;
        for (int i = 1; i < chars.length; i += 2) {
            if (!gans[chars[i] - '0'].contains(chars[i - 1] + "")) {
                gans[chars[i] - '0'] += chars[i - 1];
                if (gans[chars[i] - '0'].length() == 3) {
                    count += 1;
                    if (count == 10) {
                        break;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countPoints("B0R0"));
    }
}
