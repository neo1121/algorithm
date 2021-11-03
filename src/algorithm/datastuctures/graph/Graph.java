package algorithm.datastuctures.graph;

import java.util.*;

public class Graph {
    // data is key, node is value
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }

    public static Graph createGraph(int[][] arr) {
        // 0 weight; 1 from; 2 to
        Graph ret = new Graph();
        for (int[] ints : arr) {
            int weight = ints[0];
            int from = ints[1];
            int to = ints[2];

            if (!ret.nodes.containsKey(from)) {
                ret.nodes.put(from, new Node(from));
            }
            if (!ret.nodes.containsKey(to)) {
                ret.nodes.put(to, new Node(to));
            }

            Node fromNode = ret.nodes.get(from);
            Node toNode = ret.nodes.get(to);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;

            Edge edge = new Edge(weight, fromNode, toNode);
            fromNode.edges.add(edge);
            ret.edges.add(edge);
        }
        return ret;
    }

    public static void BFS(Node root) {
        // implement breadth first search by using queue
        Queue<Node> queue = new LinkedList<>();
        // make sure no loop is formed
        HashSet<Node> set = new HashSet<>();
        queue.add(root);
        set.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.val + " ");
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }

    public static void DFS(Node root) {
        // implement depth first search by using stack
        Stack<Node> stack = new Stack<>();
        // make sure no loop is formed
        HashSet<Node> set = new HashSet<>();
        stack.add(root);
        set.add(root);
        System.out.print(root.val + " ");
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.print(next.val + " ");
                    break;
                }
            }
        }
    }

    // need oriented graph with node whose indegree = 0
    public static void sortedTopology(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.val + " ");
            for (Node node : cur.nexts) {
                inMap.put(node, inMap.get(node) - 1);
                if (inMap.get(node) == 0) {
                    queue.add(node);
                }
            }
        }
    }

    // need undirected graph
    public static void prim(Graph graph) {
        HashSet<Node> usedNodes = new HashSet<>();
        HashSet<Edge> usedEdges = new HashSet<>();
        PriorityQueue<Edge> edges = new PriorityQueue<>((Comparator.comparingInt(o -> o.weight)));
        for (Node node : graph.nodes.values()) {
            if (usedNodes.contains(node)) continue;
            edges.addAll(node.edges);
            usedNodes.add(node);
            while (!edges.isEmpty()) {
                Edge edge = edges.poll();
                if (usedEdges.contains(edge) || (usedNodes.contains(edge.from) && usedNodes.contains(edge.to)))
                    continue;
                usedEdges.add(edge);
                System.out.print(edge.weight + " ");
                Node fromNode = edge.from;
                Node toNode = edge.to;
                if (!usedNodes.contains(fromNode)) {
                    usedNodes.add(fromNode);
                    edges.addAll(node.edges);
                }
                if (!usedNodes.contains(toNode)) {
                    usedNodes.add(toNode);
                    edges.addAll(toNode.edges);
                }
            }
        }
    }

    // need undirected graph
    public static void kruskal(Graph graph) {
        // comparator:
        // ascending order by object's weight
        // return value > 0 means the first one's weight is bigger
        // return value < 0 means the second one's weight is bigger
        HashMap<Node, HashSet<Node>> setMap = new HashMap<>();
        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        edges.addAll(graph.edges);
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            Node fromNode = edge.from;
            Node toNode = edge.to;
            HashSet<Node> fromSet = setMap.get(fromNode);
            HashSet<Node> toSet = setMap.get(toNode);
            if (fromSet == null) {
                fromSet = new HashSet<>();
                setMap.put(fromNode, fromSet);
                fromSet.add(fromNode);
            }
            if (toSet == null) {
                toSet = new HashSet<>();
                setMap.put(toNode, toSet);
                toSet.add(toNode);
            }
            if (fromSet == toSet) continue;
            for (Node node : toSet) {
                fromSet.add(node);
                setMap.put(node, fromSet);
            }
            System.out.print(edge.weight + " ");
        }

    }

    // need undirected graph without edge whose weight < 0 and a start node
    public static HashMap<Node, Integer> dijkstra(Node root) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        HashSet<Node> usedSet = new HashSet<>();
        distanceMap.put(root, 0);
        Node minNode = getMinDistanceNode(distanceMap, usedSet);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                distanceMap.merge(toNode, distance + edge.weight, Math::min);
            }
            usedSet.add(minNode);
            minNode = getMinDistanceNode(distanceMap, usedSet);
        }
        return distanceMap;
    }

    public static Node getMinDistanceNode(HashMap<Node, Integer> distanceMap, HashSet<Node> usedSet) {
        Node ret = null;
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            if (usedSet.contains(node)) continue;
            int distance = entry.getValue();
            if (distance < min) {
                min = distance;
                ret = node;
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        HashSet<Edge> edgesCopy = new HashSet<>(this.edges);
        for (Edge edge : edgesCopy) {
            Node fromNode = edge.from;
            Node toNode = edge.to;

            ret.append(fromNode.val);
            if (nodes.get(toNode.val).nexts.contains(fromNode)) {
                ret.append('<');
            } else ret.append('-');
            ret.append("------>")
                    .append(toNode.val)
                    .append("\tweight:")
                    .append(edge.weight)
                    .append('\n');
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        int[][] arr = {
                {4, 0, 1}, {4, 1, 0},
                {5, 1, 5}, {5, 5, 1},
                {3, 0, 3}, {3, 3, 0},
                {-1, 3, 6}, {-1, 6, 3},
                {1, 3, 5}, {1, 5, 3}
        };
//        int[][] arr = {
//                {4, 0, 1},
//                {5, 1, 5},
//                {3, 0, 3},
//                {-1, 3, 6},
//                {1, 3, 5},
//        };
        Graph graph = createGraph(arr);
        System.out.println("=====graph=======");
        System.out.println(graph);

//        System.out.println("======BFS=======");
//        BFS(graph.nodes.get(0));
//        System.out.println();

//        System.out.println("======DFS=======");
//        DFS(graph.nodes.get(0));
//        System.out.println();

//        System.out.println("====Topology====");
//        sortedTopology(graph);
//        System.out.println();

        System.out.println("=====Kruskal====");
        kruskal(graph);
        System.out.println();

        System.out.println("======Prim======");
        prim(graph);
        System.out.println();


    }
}
