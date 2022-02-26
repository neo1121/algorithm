package algorithm.leetcode.problem_155;

public class MinStack {
    private int[] arr;
    private int topIndex;
    private int capacity;
    private int minIndex;

    public MinStack() {
        topIndex = -1;
        capacity = 200;
        arr = new int[capacity];
        minIndex = -1;
    }

    public void push(int val) {
        topIndex += 1;
        if (topIndex >= capacity) {
            capacity *= 2;
            int[] temp = new int[capacity];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            arr = temp;
        }
        arr[topIndex] = val;
        minIndex = minIndex == -1 || arr[minIndex] > val ? topIndex : minIndex;
    }

    public void pop() {
        if (minIndex != topIndex) {
            topIndex -= 1;
            return;
        }
        minIndex = 0;
        for (int i = 1; i < topIndex; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        topIndex -= 1;
    }

    public int top() {
        return arr[topIndex];
    }

    public int getMin() {
        return arr[minIndex];
    }
}
