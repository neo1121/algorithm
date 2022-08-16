package algorithm.leetcode.problem_1656;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {
    private String[] values;
    private int ptr;
    private int n;

    public OrderedStream(int n) {
        values = new String[n];
        ptr = 0;
        this.n = n;
    }

    public List<String> insert(int idKey, String value) {
        List<String> list = new ArrayList<>();
        int index = idKey - 1;
        values[index] = value;
        if (index != ptr) {
            return list;
        }
        while (index < n && values[index] != null) {
            list.add(values[index]);
            index += 1;
        }
        ptr = index;
        return list;
    }
}
