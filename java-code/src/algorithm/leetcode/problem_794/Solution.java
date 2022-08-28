package algorithm.leetcode.problem_794;

public class Solution {
    public boolean isWin(char[] chars, char side) {
        // 横向
        for (int count = 0, beg = 0; count < 3; count++, beg += 3) {
            if (chars[beg] == side
                    && chars[beg + 1] == side
                    && chars[beg + 2] == side) {
                return true;
            }
        }
        // 纵向
        for (int count = 0, beg = 0; count < 3; count++, beg += 1) {
            if (chars[beg] == side
                    && chars[beg + 3] == side
                    && chars[beg + 6] == side) {
                return true;
            }
        }
        // 斜向
        char center = chars[4];
        if (center != side) {
            return false;
        }
        if (center == chars[0] && center == chars[8]) {
            return true;
        }
        if (center == chars[2] && center == chars[6]) {
            return true;
        }
        return false;
    }

    public boolean validTicTacToe(String[] board) {
        StringBuilder sb = new StringBuilder();
        for (String s : board) {
            sb.append(s);
        }
        char[] chars = sb.toString().toCharArray();
        int xCount = 0;
        int oCount = 0;
        for (char aChar : chars) {
            if (aChar == 'X') {
                xCount += 1;
            } else if (aChar == 'O') {
                oCount += 1;
            }
        }
        if (oCount > xCount || oCount < xCount - 1) {
            return false;
        }
        boolean xWin = isWin(chars, 'X');
        boolean oWin = isWin(chars, 'O');
        if (xWin && oWin) {
            return false;
        }
        if (xWin) {
            return oCount == xCount - 1;
        }
        if (oWin) {
            return oCount == xCount;
        }
        return true;
    }
}
