package algorithm.leetcode.problem_1476;

public class SubrectangleQueries {
    int[][] records;
    int size;
    int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.records = new int[500][5];
        this.size = -1;
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        int[] record = records[++size];
        record[0] = row1;
        record[1] = col1;
        record[2] = row2;
        record[3] = col2;
        record[4] = newValue;
    }

    public int getValue(int row, int col) {
        for (int i = size; i >= 0; i--) {
            int[] record = records[i];
            if (row < record[0] || row > record[2]) {
                continue;
            }
            if (col < record[1] || col > record[3]) {
                continue;
            }
            return record[4];
        }
        return rectangle[row][col];
    }
}
