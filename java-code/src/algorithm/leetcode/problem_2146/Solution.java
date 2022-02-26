package algorithm.leetcode.problem_2146;

import java.util.*;

public class Solution {
    public static class Item implements Comparable {
        public int distance;
        public int price;
        public int y;
        public int x;

        public Item(int distance, int price, int y, int x) {
            this.distance = distance;
            this.price = price;
            this.y = y;
            this.x = x;
        }

        public List<Integer> getCoordinate() {
            List<Integer> ret = new ArrayList<>();
            ret.add(y);
            ret.add(x);
            return ret;
        }

        @Override
        public int compareTo(Object o) {
            if (o instanceof Item) {
                Item temp = (Item) o;
                if (temp.distance != this.distance) {
                    return this.distance - temp.distance;
                }
                if (temp.price != this.price) {
                    return this.price - temp.price;
                }
                if (temp.y != this.y) {
                    return this.y - temp.y;
                }
                if (temp.x != this.x) {
                    return this.x - temp.x;
                }
            }
            return 0;
        }
    }

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<Item> minHeap = new PriorityQueue<>();
        HashMap<Integer, HashSet<Integer>> used = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        HashMap<int[], Integer> stepMap = new HashMap<>();
        queue.add(start);
        stepMap.put(start, 0);
        HashSet<Integer> set = new HashSet<>();
        set.add(start[1]);
        used.put(start[0], set);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int step = stepMap.get(cur);
            int y = cur[0];
            int x = cur[1];
            int price = grid[y][x];
            if (price >= pricing[0] && price <= pricing[1]) {
                minHeap.add(new Item(step, price, y, x));
            }
            step += 1;
            // left
            int[] left = new int[]{y, x - 1};
            if (x - 1 >= 0 && grid[y][x - 1] != 0) {
                HashSet<Integer> temp = used.get(left[0]);
                if (temp == null) {
                    temp = new HashSet<>();
                    used.put(left[0], temp);
                }
                if (temp.add(left[1])) {
                    queue.add(left);
                    stepMap.put(left, step);
                }
            }
            // right
            int[] right = new int[]{y, x + 1};
            if (x + 1 < n && grid[y][x + 1] != 0) {
                HashSet<Integer> temp = used.get(right[0]);
                if (temp == null) {
                    temp = new HashSet<>();
                    used.put(right[0], temp);
                }
                if (temp.add(right[1])) {
                    queue.add(right);
                    stepMap.put(right, step);
                }
            }
            // up
            int[] up = new int[]{y - 1, x};
            if (y - 1 >= 0 && grid[y - 1][x] != 0) {
                HashSet<Integer> temp = used.get(up[0]);
                if (temp == null) {
                    temp = new HashSet<>();
                    used.put(up[0], temp);
                }
                if (temp.add(up[1])) {
                    queue.add(up);
                    stepMap.put(up, step);
                }
            }
            // down
            int[] down = new int[]{y + 1, x};
            if (y + 1 < m && grid[y + 1][x] != 0) {
                HashSet<Integer> temp = used.get(down[0]);
                if (temp == null) {
                    temp = new HashSet<>();
                    used.put(down[0], temp);
                }
                if (temp.add(down[1])) {
                    queue.add(down);
                    stepMap.put(down, step);
                }
            }
        }
        List<List<Integer>> ret = new ArrayList<>();
        int size = minHeap.size();
        for (int i = 0; i < Math.min(k, size); i++) {
            ret.add(minHeap.poll().getCoordinate());
        }
        return ret;
    }
}
