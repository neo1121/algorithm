package algorithm.leetcode.problem_641;

public class MyCircularDeque {
    private int[] arr;
    private int size;
    private int max;
    private int rear;
    private int head;

    public MyCircularDeque(int k) {
        arr = new int[k];
        max = k;
        size = 0;
        rear = max - 1;
        head = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        arr[head] = value;
        head = (head + 1) % max;
        size += 1;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        arr[rear] = value;
        rear = rear == 0 ? max - 1 : rear - 1;
        size += 1;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = head == 0 ? max - 1 : head - 1;
        size -= 1;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear + 1) % max;
        size -= 1;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        int index = head == 0 ? max - 1 : head - 1;
        return arr[index];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        int index = (rear + 1) % max;
        return arr[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }
}
