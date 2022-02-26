package algorithm.leetcode.problem_1447;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int numerator = 1; numerator < n; numerator++) {
            for (int denominator = numerator + 1; denominator <= n; denominator++) {
                if (isSimplified(denominator, numerator)) {
                    ans.add(numerator + "/" + denominator);
                }
            }
        }
        return ans;
    }

    public boolean isSimplified(int denominator, int numerator) {
        for (int i = numerator; i > 1; i--) {
            if (numerator % i == 0 && denominator % i == 0) {
                return false;
            }
        }
        return true;
    }
}
