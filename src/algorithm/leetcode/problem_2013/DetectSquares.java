package algorithm.leetcode.problem_2013;

public class DetectSquares {
    public int[][] graph;


    public DetectSquares() {
        graph = new int[1001][1001];
    }

    public void add(int[] point) {
        graph[point[0]][point[1]] += 1;
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int[] row = graph[x];
        int ret = 0;
        for (int i = 0; i < row.length; i++) {
            if (i == y || row[i] < 1) {
                continue;
            }
            int edgeLength = Math.abs(y - i);
            int commonPoint = graph[x][i];
            int aPoint = x - edgeLength >= 0 ? graph[x - edgeLength][y] : 0;
            int bPoint = x + edgeLength <= 1000 ? graph[x + edgeLength][y] : 0;
            int cPoint = x - edgeLength >= 0 ? graph[x - edgeLength][i] : 0;
            int dPoint = x + edgeLength <= 1000 ? graph[x + edgeLength][i] : 0;
            ret += (aPoint * bPoint + cPoint * dPoint) * commonPoint;
        }
        return ret;
    }
}
