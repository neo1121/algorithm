package algorithm.leetcode.problem_386;

import java.util.*;

public class Solution {
    // 常规思路, 用字典树
    static class Node {

        Node[] nexts;

        public Node() {
            nexts = new Node[10];
        }
    }

    List<Integer> list = new ArrayList<>();

    public void insert(Node root, int num) {
        String s = Integer.toString(num);
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - '0';
            if (cur.nexts[index] == null) {
                cur.nexts[index] = new Node();
            }
            cur = cur.nexts[index];
        }
    }

    public void dfs(Node root) {
        StringBuilder sb = new StringBuilder();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node cur = stack.peek();
            boolean isEnd = true;
            for (int i = 0; i < cur.nexts.length; i++) {
                Node next = cur.nexts[i];
                if (next != null) {
                    sb.append(i);
                    list.add(Integer.parseInt(sb.toString()));
                    stack.push(next);
                    cur.nexts[i] = null;
                    isEnd = false;
                    break;
                }
            }
            if (isEnd) {
                stack.pop();
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    public List<Integer> lexicalOrder(int n) {
        Node root = new Node();
        for (int i = 1; i <= n; i++) {
            insert(root, i);
        }
        dfs(root);
        return list;
    }

    // 抽象字典树
    public void dfs2(List<Integer> list, int pre, int n) {
        for (int i = 0; i < 10; i++) {
            int cur = pre * 10 + i;
            if (cur > n) {
                return;
            }
            list.add(cur);
            dfs2(list, cur, n);
        }
    }

    public List<Integer> lexicalOrder2(int n) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            if (i > n) {
                break;
            }
            ret.add(i);
            dfs2(ret, i, n);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lexicalOrder2(1000));
    }
}
