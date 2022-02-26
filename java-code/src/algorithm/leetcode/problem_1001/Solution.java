package algorithm.leetcode.problem_1001;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public HashMap<Integer, Integer> row;
    public HashMap<Integer, Integer> col;
    public HashMap<Integer, Integer> diagonal;
    public HashMap<Integer, Integer> antiDiagonal;
    public HashSet<Long> lights;

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        row = new HashMap<>();
        col = new HashMap<>();
        diagonal = new HashMap<>();
        antiDiagonal = new HashMap<>();
        lights = new HashSet<>();
        int[] ans = new int[queries.length];
        for (int[] lamp : lamps) {
            turnOn(lamp[0], lamp[1]);
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = query[0];
            int y = query[1];
            ans[i] = check(x, y) ? 1 : 0;
            for (int j = x - 1; j < x + 3; j++) {
                for (int k = y - 1; k < y + 3; k++) {
                    turnOff(j, k);
                }
            }
        }
        return ans;
    }

    public void turnOn(int x, int y) {
        if (!lights.add(hash(x, y))) {
            return;
        }
        row.put(x, row.getOrDefault(x, 0) + 1);
        col.put(y, col.getOrDefault(y, 0) + 1);
        diagonal.put(y - x, diagonal.getOrDefault(y - x, 0) + 1);
        antiDiagonal.put(y + x, antiDiagonal.getOrDefault(y + x, 0) + 1);
    }

    public void turnOff(int x, int y) {
        if (!lights.remove(hash(x, y))) {
            return;
        }
        row.put(x, row.get(x) - 1);
        col.put(y, col.get(y) - 1);
        diagonal.put(y - x, diagonal.get(y - x) - 1);
        antiDiagonal.put(y + x, antiDiagonal.get(y + x) - 1);
    }

    public boolean check(int x, int y) {
        if (lights.contains(hash(x, y))) {
            return true;
        } else if (row.getOrDefault(x, 0) > 0) {
            return true;
        } else if (col.getOrDefault(y, 0) > 0) {
            return true;
        } else if (diagonal.getOrDefault(y - x, 0) > 0) {
            return true;
        } else if (antiDiagonal.getOrDefault(y + x, 0) > 0) {
            return true;
        }
        return false;
    }

    public long hash(int x, int y) {
        return (long) (x * 1e9) + y;
    }
}
