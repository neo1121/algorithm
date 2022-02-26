package algorithm.datastuctures.graph;

import java.util.ArrayList;

public class Node{
    public int val;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int val) {
        this.val = val;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
