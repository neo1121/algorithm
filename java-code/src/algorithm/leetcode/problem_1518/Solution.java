package algorithm.leetcode.problem_1518;

public class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ret = 0;
        while (numBottles >= numExchange) {
            int lastBottles = numBottles % numExchange;
            ret += numBottles - lastBottles;
            numBottles = lastBottles + numBottles / numExchange;
        }
        return ret + numBottles;
    }
}
