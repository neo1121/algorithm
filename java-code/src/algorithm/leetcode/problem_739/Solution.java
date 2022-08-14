package algorithm.leetcode.problem_739;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] temperatureStack = new int[temperatures.length];
        int temperatureTop = -1;
        int[] indexStack = new int[temperatures.length];
        int indexTop = -1;
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (temperatureTop > -1 && temperatureStack[temperatureTop] < temperatures[i]) {
                ans[indexStack[indexTop]] = i - indexStack[indexTop];
                indexTop -= 1;
                temperatureTop -= 1;
            }
            temperatureStack[++temperatureTop] = temperatures[i];
            indexStack[++indexTop] = i;
        }
        while (indexTop > -1) {
            ans[indexStack[indexTop--]] = 0;
        }
        return ans;
    }
}
