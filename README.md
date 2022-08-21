# Algorithm

收录学习算法过程中在 [LeetCode](https://leetcode.cn/) 上做的题

学习资料: [左程云算法课程](https://www.bilibili.com/video/BV13g41157hK?spm_id_from=333.999.0.0)

[我的力扣主页](https://leetcode.cn/u/neohv/)

A collection of problems solved on the [LeetCode](https://leetcode.cn/) when watching [左程云算法课程](https://www.bilibili.com/video/BV13g41157hK?spm_id_from=333.999.0.0).

[My LeetCode Homepage](https://leetcode.cn/u/neohv/)

# HOT 100

## 84.柱状图中最大的矩形

给定 *n* 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。

链接: https://leetcode.cn/problems/largest-rectangle-in-histogram/

分析: 每个柱子能构成的面积最大的矩形的高是该柱子的高度, 宽是左右两边第一个高度小于该柱子高度的两个柱子之间的距离

Java code

```java
// 单调栈
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int h = heights[stack.pop()];
                int l = stack.isEmpty() ? -1 : stack.peek();
                int area = h * (i - l - 1);
                max = Math.max(area, max);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int l = stack.isEmpty() ? -1 : stack.peek();
            int area = h * (heights.length - l - 1);
            max = Math.max(area, max);
        }
        return max;
    }
}
```

```java
// 单调栈
// 优化1: 数组实现栈
class Solution {
    public int largestRectangleArea(int[] heights) {
        // 
        int[] stack = new int[heights.length]; 
        int top = -1;
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (top > -1 && heights[stack[top]] > heights[i]) {
                int h = heights[stack[top--]];
                int l = top == -1 ? -1 : stack[top];
                int area = h * (i - l - 1);
                max = Math.max(area, max);
            }
            stack[++top] = i;
        }
        while (top > -1) {
            int h = heights[stack[top--]];
            int l = top == -1 ? -1 : stack[top];
            int area = h * (heights.length - l - 1);
            max = Math.max(area, max);
        }
        return max;
    }
}
```

```java
// 单调栈
// 优化2: 弹出相同高度的索引
class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] stack = new int[heights.length];
        int top = -1;
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (top > -1 && heights[stack[top]] > heights[i]) {
                int h = heights[stack[top--]];
                // 
                while (top > -1 && heights[stack[top]] == h) {
                    top -= 1;
                }
                int l = top == -1 ? -1 : stack[top];
                int area = h * (i - l - 1);
                max = Math.max(area, max);
            }
            stack[++top] = i;
        }
        while (top > -1) {
            int h = heights[stack[top--]];
            // 
            while (top > -1 && heights[stack[top]] == h) {
                top -= 1;
            }
            int l = top == -1 ? -1 : stack[top];
            int area = h * (heights.length - l - 1);
            max = Math.max(area, max);
        }
        return max;
    }
}
```

## 85.最大矩形

给定一个仅包含 `0` 和 `1` 、大小为 `rows x cols` 的二维二进制矩阵，找出只包含 `1` 的最大矩形，并返回其面积。

链接: https://leetcode.cn/problems/maximal-rectangle/

分析: 此题与 [84.柱状图中最大的矩形](#84.柱状图中最大的矩形) 类似, 可将二维数组视为一维数组, 统计连续 "1" 的个数, 对每行求最大矩形面积

Java code

```java
// 单调栈
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            ans = Math.max(ans, getMax(heights));
        }
        return ans;
    }

    static int getMax(int[] heights) {
        int[] indexStack = new int[heights.length];
        int top = -1;
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            while (top > -1 && heights[indexStack[top]] > heights[i]) {
                int h = heights[indexStack[top--]];
                while (top > -1 && h == heights[indexStack[top]]) {
                    top -= 1;
                }
                int l = top > -1 ? indexStack[top] : -1;
                area = Math.max(area, h * (i - l - 1));
            }
            indexStack[++top] = i;
        }
        while (top > -1) {
            int h = heights[indexStack[top--]];
            while (top > -1 && h == heights[indexStack[top]]) {
                top -= 1;
            }
            int l = top > -1 ? indexStack[top] : -1;
            area = Math.max(area, h * (heights.length - l - 1));
        }
        return area;
    }
}
```

## 105.从前序与中序遍历序列构造二叉树

给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。

链接: https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal

分析: 前序遍历序列总是 [根节点 [左子树] [右子树]], 中序遍历序列总是 [[左子树] 根节点 [右子树]], 对遍历序列进行递归即可构造出二叉树

Java code

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// 直接 copy 数组
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        for (; i < n; i++) {
            if (inorder[i] == preorder[0]) {
                break;
            }
        }
        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, i + 1),
                Arrays.copyOfRange(inorder, 0, i)
        );
        root.right = buildTree(
                Arrays.copyOfRange(preorder, i + 1, n),
                Arrays.copyOfRange(inorder, i + 1, n)
        );
        return root;
    }
}
```

```java
// 优化: 使用索引
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, preorder.length);
    }

    static TreeNode build(int[] preorder, int[] inorder, int ps, int is, int len) {
        if (len <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        int i = is;
        for (; i < is + len; i++) {
            if (inorder[i] == preorder[ps]) {
                break;
            }
        }
        root.left = build(
                preorder,
                inorder,
                ps + 1,
                is,
                i - is
        );
        root.right = build(
                preorder,
                inorder,
                ps + 1 + i - is,
                i + 1,
                len - i + is - 1
        );
        return root;
    }
}
```

## 221.最大正方形

在一个由 `'0'` 和 `'1'` 组成的二维矩阵内，找到只包含 `'1'` 的最大正方形，并返回其面积。

链接: https://leetcode.cn/problems/maximal-square/

分析: 矩阵求面积, 类比 [85.最大矩形](#最大矩形) 做法, 将其中的面积结算改为宽高中小的值的平方

Java code

```java
// 单调栈
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            ans = Math.max(ans, getMax(heights));
        }
        return ans;
    }

    static int getMax(int[] heights) {
        int[] indexStack = new int[heights.length];
        int top = -1;
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            while (top > -1 && heights[indexStack[top]] > heights[i]) {
                int h = heights[indexStack[top--]];
                while (top > -1 && h == heights[indexStack[top]]) {
                    top -= 1;
                }
                int l = top > -1 ? indexStack[top] : -1;
                int w = i - l - 1;
                int len = Math.min(w, h);
                area = Math.max(area, len * len);
            }
            indexStack[++top] = i;
        }
        while (top > -1) {
            int h = heights[indexStack[top--]];
            while (top > -1 && h == heights[indexStack[top]]) {
                top -= 1;
            }
            int l = top > -1 ? indexStack[top] : -1;
            int w = heights.length - l - 1;
            int len = Math.min(w, h);
            area = Math.max(area, len * len);
        }
        return area;
    }
}
```

## 617.合并二叉树

给你两棵二叉树： root1 和 root2 。

想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。

返回合并后的二叉树。

注意: 合并过程必须从两个树的根节点开始。

链接: https://leetcode.cn/problems/merge-two-binary-trees

分析: 树上每个节点的合并逻辑相同, 直接递归

Java code

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }
}
```

# Problems

## 排序

| ID            |                            Title                             | Difficulty | Java |  Go  |
| :------------ | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 56            |  [合并区间](https://leetcode.cn/problems/merge-intervals/)   |   Medium   |  √   |      |
| 75            |    [颜色分类](https://leetcode.cn/problems/sort-colors/)     |   Medium   |  √   |      |
| 88            | [合并两个有序数组](https://leetcode.cn/problems/merge-sorted-array) |    Easy    |  √   |      |
| 215           | [数组中的第K个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array/) |   Medium   |  √   |  √   |
| 506           |   [相对名次](https://leetcode.cn/problems/relative-ranks)    |    Easy    |  √   |      |
| 899           |   [有序队列](https://leetcode.cn/problems/orderly-queue/)    |    Hard    |  √   |      |
| 912           |    [排序数组](https://leetcode.cn/problems/sort-an-array)    |   Medium   |  √   |      |
| 1996          | [游戏中弱角色的数量](https://leetcode.cn/problems/the-number-of-weak-characters-in-the-game/) |   Medium   |  √   |      |
| 2191          | [将杂乱无章的数字排序](https://leetcode.cn/problems/sort-the-jumbled-numbers/) |   Medium   |  √   |      |
| 剑指 Offer 51 | [数组中的逆序对](https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/) |    Hard    |  √   |      |

### 常见排序算法比较

|      | 时间复杂度    | 空间复杂度   | 能否实现稳定性 |
|:----:|:--------:|:-------:|:-------:|
| 选择排序 | O(n²)    | O(1)    | ×       |
| 冒泡排序 | O(n²)    | O(1)    | √       |
| 插入排序 | O(n²)    | O(1)    | √       |
| 归并排序 | O(nlogn) | O(n)    | √       |
| 快速排序 | O(nlogn) | O(logn) | ×       |
| 堆排序  | O(nlogn) | O(1)    | ×       |

## 队列

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 641  | [设计循环双端队列](https://leetcode.cn/problems/design-circular-deque/) |   Medium   |  √   |      |
| 2149 | [按符号重排数组](https://leetcode.cn/problems/rearrange-array-elements-by-sign/) |   Medium   |  √   |      |

## 堆

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 4    | [寻找两个正序数组的中位数](https://leetcode.cn/problems/median-of-two-sorted-arrays/) |    Hard    |  √   |      |
| 295  | [数据流的中位数](https://leetcode.cn/problems/find-median-from-data-stream) |    Hard    |  √   |      |
| 373  | [查找和最小的 K 对数字](https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/) |   Medium   |  √   |      |
| 2161 | [根据给定数字划分数组](https://leetcode.cn/problems/partition-array-according-to-given-pivot/) |   Medium   |  √   |      |
| 2164 | [对奇偶下标分别排序](https://leetcode.cn/problems/sort-even-and-odd-indices-independently/) |    Easy    |  √   |      |
| 2182 | [构造限制重复的字符串](https://leetcode.cn/problems/construct-string-with-repeat-limit/) |   Medium   |  √   |      |

## 栈

| ID   |                          Title                          | Difficulty | Java |  Go  |
| :--- | :-----------------------------------------------------: | :--------: | :--: | :--: |
| 71   | [简化路径](https://leetcode.cn/problems/simplify-path/) |   Medium   |  √   |      |
| 155  |    [最小栈](https://leetcode.cn/problems/min-stack/)    |    Easy    |  √   |      |

## 链表

| ID                |                            Title                             | Difficulty | Java |  Go  | C++  |
| :---------------- | :----------------------------------------------------------: | :--------: | :--: | :--: | :--: |
| 2                 |  [两数相加](https://leetcode.cn/problems/add-two-numbers/)   |   Medium   |      |  √   |  √   |
| 19                | [删除链表的倒数第 N 个结点](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/) |   Medium   |  √   |      |      |
| 21                | [合并两个有序链表](https://leetcode.cn/problems/merge-two-sorted-lists/) |    Easy    |  √   |      |      |
| 23                | [合并K个升序链表](https://leetcode.cn/problems/merge-k-sorted-lists/) |    Hard    |  √   |      |      |
| 24                | [两两交换链表中的节点](https://leetcode.cn/problems/swap-nodes-in-pairs/) |   Medium   |  √   |      |      |
| 61                |     [旋转链表](https://leetcode.cn/problems/rotate-list)     |   Medium   |  √   |      |      |
| 82                | [删除排序链表中的重复元素 II](https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii) |   Medium   |  √   |      |      |
| 83                | [删除排序链表中的重复元素](https://leetcode.cn/problems/remove-duplicates-from-sorted-list) |    Easy    |  √   |      |      |
| 86                |   [分隔链表](https://leetcode.cn/problems/partition-list)    |   Medium   |  √   |  √   |      |
| 92                | [反转链表 II](https://leetcode.cn/problems/reverse-linked-list-ii) |   Medium   |  √   |      |      |
| 138               | [复制带随机指针的链表](https://leetcode.cn/problems/copy-list-with-random-pointer) |   Medium   |  √   |      |      |
| 141               |  [环形链表](https://leetcode.cn/problems/linked-list-cycle)  |    Easy    |  √   |      |      |
| 142               | [环形链表 II](https://leetcode.cn/problems/linked-list-cycle-ii) |   Medium   |  √   |      |      |
| 148               |      [排序链表](https://leetcode.cn/problems/sort-list)      |   Medium   |  √   |      |      |
| 160               | [相交链表](https://leetcode.cn/problems/intersection-of-two-linked-lists) |    Easy    |  √   |      |      |
| 203               | [移除链表元素](https://leetcode.cn/problems/remove-linked-list-elements) |    Easy    |  √   |      |      |
| 206               | [反转链表](https://leetcode.cn/problems/reverse-linked-list) |    Easy    |  √   |      |      |
| 234               | [回文链表](https://leetcode.cn/problems/palindrome-linked-list) |    Easy    |  √   |      |      |
| 237               | [删除链表中的节点](https://leetcode.cn/problems/delete-node-in-a-linked-list) |    Easy    |  √   |      |      |
| 328               | [奇偶链表](https://leetcode.cn/problems/odd-even-linked-list) |   Medium   |  √   |      |      |
| 725               | [分隔链表](https://leetcode.cn/problems/split-linked-list-in-parts) |   Medium   |  √   |      |      |
| 876               | [链表的中间结点](https://leetcode.cn/problems/middle-of-the-linked-list) |    Easy    |  √   |      |      |
| 2095              | [删除链表的中间节点](https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/) |   Medium   |  √   |      |      |
| 2130              | [链表最大孪生和](https://leetcode.cn/problems/maximum-twin-sum-of-a-linked-list/) |   Medium   |  √   |      |      |
| 2181              | [合并零之间的节点](https://leetcode.cn/problems/merge-nodes-in-between-zeros/) |   Medium   |  √   |      |      |
| 剑指 Offer II 027 |       [回文链表](https://leetcode.cn/problems/aMhZSa/)       |    Easy    |  √   |      |      |

## 树

| ID                |                            Title                             | Difficulty | Java |  Go  |
| :---------------- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 94                | [二叉树的中序遍历](https://leetcode.cn/problems/binary-tree-inorder-traversal) |    Easy    |  √   |      |
| 98                | [验证二叉搜索树](https://leetcode.cn/problems/validate-binary-search-tree) |   Medium   |  √   |  √   |
| 100               |     [相同的树](https://leetcode.com/problems/same-tree/)     |    Easy    |  √   |      |
| 102               | [二叉树的层序遍历](https://leetcode.cn/problems/binary-tree-level-order-traversal) |   Medium   |  √   |      |
| 104               | [二叉树的最大深度](https://leetcode.cn/problems/maximum-depth-of-binary-tree) |    Easy    |  √   |      |
| 105               | [从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) |   Medium   |  √   |      |
| 107               | [二叉树的层序遍历 II](https://leetcode.cn/problems/binary-tree-level-order-traversal-ii) |   Medium   |  √   |      |
| 110               | [平衡二叉树](https://leetcode.cn/problems/balanced-binary-tree) |    Easy    |  √   |      |
| 114               | [二叉树展开为链表](https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/) |   Medium   |  √   |  √   |
| 144               | [二叉树的前序遍历](https://leetcode.cn/problems/binary-tree-preorder-traversal) |    Easy    |  √   |      |
| 145               | [二叉树的后序遍历](https://leetcode.cn/problems/binary-tree-postorder-traversal) |    Easy    |  √   |      |
| 222               | [完全二叉树的节点个数](https://leetcode.cn/problems/count-complete-tree-nodes) |   Medium   |  √   |      |
| 226               | [翻转二叉树](https://leetcode.cn/problems/invert-binary-tree/) |    Easy    |  √   |  √   |
| 236               | [二叉树的最近公共祖先](https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree) |   Medium   |  √   |      |
| 297               | [二叉树的序列化与反序列化](https://leetcode.cn/problems/serialize-and-deserialize-binary-tree) |    Hard    |  √   |      |
| 429               | [N 叉树的层序遍历](https://leetcode.cn/problems/n-ary-tree-level-order-traversal/) |   Medium   |  √   |  √   |
| 513               | [找树左下角的值](https://leetcode.cn/problems/find-bottom-left-tree-value/) |   Medium   |      |  √   |
| 543               | [二叉树的直径](https://leetcode.cn/problems/diameter-of-binary-tree/) |    Easy    |  √   |  √   |
| 589               | [N 叉树的前序遍历](https://leetcode.cn/problems/n-ary-tree-preorder-traversal/) |    Easy    |  √   |      |
| 606               | [根据二叉树创建字符串](https://leetcode.cn/problems/construct-string-from-binary-tree/) |    Easy    |  √   |  √   |
| 653               | [两数之和 IV - 输入 BST](https://leetcode.cn/problems/two-sum-iv-input-is-a-bst/) |    Easy    |  √   |  √   |
| 654               | [最大二叉树](https://leetcode.cn/problems/maximum-binary-tree/) |   Medium   |  √   |      |
| 1302              | [层数最深叶子节点的和](https://leetcode.cn/problems/deepest-leaves-sum/) |   Medium   |  √   |  √   |
| 1609              |    [奇偶树](https://leetcode.cn/problems/even-odd-tree/)     |   Medium   |  √   |      |
| 2049              | [统计最高分的节点数目](https://leetcode.cn/problems/count-nodes-with-the-highest-score/) |   Medium   |  √   |      |
| 2096              | [从二叉树一个节点到另一个节点每一步的方向](https://leetcode.cn/problems/step-by-step-directions-from-a-binary-tree-node-to-another/) |   Medium   |  √   |      |
| 2196              | [根据描述创建二叉树](https://leetcode.cn/problems/create-binary-tree-from-descriptions/) |   Medium   |  √   |      |
| 剑指 Offer II 053 | [二叉搜索树中的中序后继](https://leetcode.cn/problems/P5rCT8/) |   Medium   |  √   |      |

## 图

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 207  |   [课程表](https://leetcode.cn/problems/course-schedule/)    |   Medium   |  √   |      |
| 210  | [课程表 II](https://leetcode.cn/problems/course-schedule-ii/) |   Medium   |  √   |      |
| 547  | [省份数量](https://leetcode.cn/problems/number-of-provinces) |   Medium   |  √   |      |
| 684  | [冗余连接](https://leetcode.cn/problems/redundant-connection) |   Medium   |  √   |      |
| 851  |  [喧闹和富有](https://leetcode.cn/problems/loud-and-rich/)   |   Medium   |  √   |      |
| 2192 | [有向无环图中一个节点的所有祖先](https://leetcode.cn/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/) |   Medium   |  √   |      |

## 前缀树

| ID                |                            Title                             | Difficulty | Java |  Go  |
| :---------------- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 208               | [实现 Trie (前缀树)](https://leetcode.cn/problems/implement-trie-prefix-tree) |   Medium   |  √   |      |
| 剑指 Offer II 062 |      [实现前缀树](https://leetcode.cn/problems/QC3q1f/)      |   Medium   |  √   |      |

## 并查集

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 128  | [最长连续序列](https://leetcode.cn/problems/longest-consecutive-sequence/) |   Medium   |  √   |      |

## 贪心策略

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 5    | [最长回文子串](https://leetcode.cn/problems/longest-palindromic-substring/) |   Medium   |  √   |      |
| 11   | [盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/) |   Medium   |  √   |      |
| 45   |  [跳跃游戏 II](https://leetcode.cn/problems/jump-game-ii/)   |   Medium   |  √   |      |
| 55   |     [跳跃游戏](https://leetcode.cn/problems/jump-game/)      |   Medium   |  √   |      |
| 179  |    [最大数](https://leetcode.cn/problems/largest-number/)    |   Medium   |  √   |      |
| 334  | [递增的三元子序列](https://leetcode.cn/problems/increasing-triplet-subsequence/) |   Medium   |  √   |      |
| 435  | [无重叠区间](https://leetcode.cn/problems/non-overlapping-intervals/) |   Medium   |  √   |      |
| 455  |   [分发饼干](https://leetcode.cn/problems/assign-cookies/)   |    Easy    |  √   |      |
| 768  | [最多能完成排序的块 II](https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/) |    Hard    |  √   |      |
| 807  | [保持城市天际线](https://leetcode.cn/problems/max-increase-to-keep-city-skyline/) |   Medium   |  √   |      |
| 846  | [一手顺子](https://leetcode.cn/problems/hand-of-straights/)  |   Medium   |  √   |      |
| 969  |  [煎饼排序](https://leetcode.cn/problems/pancake-sorting/)   |   Medium   |  √   |      |
| 1005 | [K 次取反后最大化的数组和](https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations) |    Easy    |  √   |      |
| 1405 | [最长快乐字符串](https://leetcode.cn/problems/longest-happy-string/) |   Medium   |  √   |      |
| 1414 | [和为 K 的最少斐波那契数字数目](https://leetcode.cn/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/) |   Medium   |  √   |      |
| 2126 | [摧毁小行星](https://leetcode.cn/problems/destroying-asteroids/) |   Medium   |  √   |      |
| 2139 | [得到目标值的最少行动次数](https://leetcode.cn/problems/minimum-moves-to-reach-target-score/) |   Medium   |  √   |      |
| 2144 | [打折购买糖果的最小开销](https://leetcode.cn/problems/minimum-cost-of-buying-candies-with-discount/) |    Easy    |  √   |      |
| 2145 | [统计隐藏数组数目](https://leetcode.cn/problems/count-the-hidden-sequences/) |   Medium   |  √   |      |
| 2160 | [拆分数位后四位数字的最小和](https://leetcode.cn/problems/minimum-sum-of-four-digit-number-after-splitting-digits/) |    Easy    |  √   |      |
| 2165 | [重排数字的最小值](https://leetcode.cn/problems/smallest-value-of-the-rearranged-number/) |   Medium   |  √   |      |
| 2178 | [拆分成最多数目的偶整数之和](https://leetcode.cn/problems/maximum-split-of-positive-even-integers/) |   Medium   |  √   |      |
| 2195 | [向数组中追加 K 个整数](https://leetcode.cn/problems/append-k-integers-with-minimal-sum/) |   Medium   |  √   |      |
| 2207 | [字符串中最多数目的子字符串](https://leetcode.cn/problems/maximize-number-of-subsequences-in-a-string/) |   Medium   |  √   |      |
| 2208 | [将数组和减半的最少操作次数](https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/) |   Medium   |  √   |      |
| 2216 | [美化数组的最少删除数](https://leetcode.cn/problems/minimum-deletions-to-make-array-beautiful/) |   Medium   |  √   |      |

## 暴力递归

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 62   |    [不同路径](https://leetcode.cn/problems/unique-paths/)    |   Medium   |  √   |      |
| 64   | [最小路径和](https://leetcode.cn/problems/minimum-path-sum/) |   Medium   |  √   |      |
| 486  | [预测赢家](https://leetcode.cn/problems/predict-the-winner/) |   Medium   |  √   |      |

## 回溯

| ID            |                            Title                             | Difficulty | Java |  Go  |
| :------------ | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 17            | [电话号码的字母组合](https://leetcode.cn/problems/letter-combinations-of-a-phone-number/) |   Medium   |  √   |      |
| 22            | [括号生成](https://leetcode.cn/problems/generate-parentheses/) |   Medium   |  √   |      |
| 46            |     [全排列](https://leetcode.cn/problems/permutations/)     |   Medium   |  √   |      |
| 47            |  [全排列 II](https://leetcode.cn/problems/permutations-ii/)  |   Medium   |  √   |      |
| 52            |    [N皇后 II](https://leetcode.cn/problems/n-queens-ii/)     |    Hard    |  √   |      |
| 78            |        [子集](https://leetcode.cn/problems/subsets/)         |   Medium   |  √   |      |
| 357           | [统计各位数字都不同的数字个数](https://leetcode.cn/problems/count-numbers-with-unique-digits/) |   Medium   |  √   |  √   |
| 784           | [字母大小写全排列](https://leetcode.cn/problems/letter-case-permutation/) |   Medium   |  √   |      |
| 2044          | [统计按位或能得到最大值的子集数目](https://leetcode.cn/problems/count-number-of-maximum-bitwise-or-subsets/) |   Medium   |  √   |  √   |
| 2212          | [射箭比赛中的最大得分](https://leetcode.cn/problems/maximum-points-in-an-archery-competition/) |   Medium   |  √   |      |
| 剑指 Offer 38 | [字符串的排列](https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/) |   Medium   |  √   |      |

## 滑动窗口

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 3    | [无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters/) |   Medium   |  √   |      |
| 219  | [存在重复元素 II](https://leetcode.cn/problems/contains-duplicate-ii/) |    Easy    |  √   |      |
| 220  | [存在重复元素 III](https://leetcode.cn/problems/contains-duplicate-iii/) |   Medium   |  √   |      |

## 哈希

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 49   | [字母异位词分组](https://leetcode.cn/problems/group-anagrams/) |   Medium   |  √   |      |
| 167  | [两数之和 II - 输入有序数组](https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/) |   Medium   |  √   |  √   |
| 217  | [存在重复元素](https://leetcode.cn/problems/contains-duplicate/) |    Easy    |  √   |      |
| 219  | [存在重复元素 II](https://leetcode.cn/problems/contains-duplicate-ii/) |    Easy    |  √   |      |
| 599  | [两个列表的最小索引总和](https://leetcode.cn/problems/minimum-index-sum-of-two-lists/) |    Easy    |  √   |  √   |
| 653  | [两数之和 IV - 输入 BST](https://leetcode.cn/problems/two-sum-iv-input-is-a-bst/) |    Easy    |  √   |      |
| 720  | [词典中最长的单词](https://leetcode.cn/problems/longest-word-in-dictionary/) |    Easy    |  √   |      |
| 804  | [唯一摩尔斯密码词](https://leetcode.cn/problems/unique-morse-code-words/) |    Easy    |  √   |  √   |
| 884  | [两句话中的不常见单词](https://leetcode.cn/problems/uncommon-words-from-two-sentences/) |    Easy    |  √   |      |
| 1001 | [网格照明](https://leetcode.cn/problems/grid-illumination/)  |    Hard    |  √   |      |
| 1656 | [设计有序流](https://leetcode.cn/problems/design-an-ordered-stream/) |    Easy    |  √   |      |
| 2215 | [找出两数组的不同](https://leetcode.cn/problems/find-the-difference-of-two-arrays/) |    Easy    |  √   |      |

## 字符串

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 6    | [Z 字形变换](https://leetcode.cn/problems/zigzag-conversion/) |   Medium   |  √   |  √   |
| 14   | [最长公共前缀](https://leetcode.cn/problems/longest-common-prefix/) |    Easy    |  √   |      |
| 58   | [最后一个单词的长度](https://leetcode.cn/problems/length-of-last-word) |    Easy    |  √   |      |
| 306  |   [累加数](https://leetcode.cn/problems/additive-number/)    |   Medium   |  √   |      |
| 383  |      [赎金信](https://leetcode.cn/problems/ransom-note)      |    Easy    |  √   |      |
| 392  |  [判断子序列](https://leetcode.cn/problems/is-subsequence/)  |    Easy    |  √   |  √   |
| 686  | [重复叠加字符串匹配](https://leetcode.cn/problems/repeated-string-match/) |   Medium   |  √   |      |
| 709  | [转换成小写字母](https://leetcode.cn/problems/to-lower-case/) |    Easy    |  √   |      |
| 748  | [最短补全词](https://leetcode.cn/problems/shortest-completing-word/) |    Easy    |  √   |      |
| 796  |  [旋转字符串](https://leetcode.cn/problems/rotate-string/)   |    Easy    |  √   |  √   |
| 917  | [仅仅反转字母](https://leetcode.cn/problems/reverse-only-letters/) |    Easy    |  √   |      |
| 1078 | [Bigram 分词](https://leetcode.cn/problems/occurrences-after-bigram/) |    Easy    |  √   |      |
| 1189 | [“气球” 的最大数量](https://leetcode.cn/problems/maximum-number-of-balloons/) |    Easy    |  √   |      |
| 1332 | [删除回文子序列](https://leetcode.cn/problems/remove-palindromic-subsequences/) |    Easy    |  √   |      |
| 1422 | [分割字符串的最大得分](https://leetcode.cn/problems/maximum-score-after-splitting-a-string/) |    Easy    |  √   |      |
| 1446 | [连续字符](https://leetcode.cn/problems/consecutive-characters/) |    Easy    |  √   |      |
| 1455 | [检查单词是否为句中其他单词的前缀](https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/) |    Easy    |  √   |      |
| 1576 | [替换所有的问号](https://leetcode.cn/problems/replace-all-s-to-avoid-consecutive-repeating-characters/) |    Easy    |  √   |      |
| 1614 | [括号的最大嵌套深度](https://leetcode.cn/problems/maximum-nesting-depth-of-the-parentheses/) |    Easy    |  √   |      |
| 1629 | [按键持续时间最长的键](https://leetcode.cn/problems/slowest-key/) |    Easy    |  √   |      |
| 1816 |  [截断句子](https://leetcode.cn/problems/truncate-sentence)  |    Easy    |  √   |      |
| 1859 | [将句子排序](https://leetcode.cn/problems/sorting-the-sentence/) |    Easy    |  √   |      |
| 2000 | [反转单词前缀](https://leetcode.cn/problems/reverse-prefix-of-word) |    Easy    |  √   |      |
| 2047 | [句子中的有效单词数](https://leetcode.cn/problems/number-of-valid-words-in-a-sentence/) |    Easy    |  √   |      |
| 2108 | [找出数组中的第一个回文字符串](https://leetcode.cn/problems/find-first-palindromic-string-in-the-array/) |    Easy    |  √   |      |
| 2109 | [向字符串添加空格](https://leetcode.cn/problems/adding-spaces-to-a-string/) |   Medium   |  √   |      |
| 2114 | [句子中的最多单词数](https://leetcode.cn/problems/maximum-number-of-words-found-in-sentences/) |    Easy    |  √   |      |
| 2124 | [检查是否所有 A 都在 B 之前](https://leetcode.cn/problems/check-if-all-as-appears-before-all-bs/) |    Easy    |  √   |      |
| 2129 | [将标题首字母大写](https://leetcode.cn/problems/capitalize-the-title/) |    Easy    |  √   |      |
| 2138 | [将字符串拆分为若干长度为 k 的组](https://leetcode.cn/problems/divide-a-string-into-groups-of-size-k/) |    Easy    |  √   |      |
| 2156 | [查找给定哈希值的子串](https://leetcode.cn/problems/find-substring-with-given-hash-value/) |   Medium   |  √   |      |
| 2185 | [统计包含给定前缀的字符串](https://leetcode.cn/problems/counting-words-with-a-given-prefix/) |    Easy    |  √   |      |
| 2186 | [使两字符串互为字母异位词的最少步骤数](https://leetcode.cn/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/) |   Medium   |  √   |      |

## KMP

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 28   | [实现 strStr()](https://leetcode.cn/problems/implement-strstr/) |    Easy    |  √   |  √   |

## 单调栈

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 84   | [柱状图中最大的矩形](https://leetcode.cn/problems/largest-rectangle-in-histogram/) |    Hard    |  √   |      |
| 85   | [最大矩形](https://leetcode.cn/problems/maximal-rectangle/)  |    Hard    |  √   |      |
| 221  |  [最大正方形](https://leetcode.cn/problems/maximal-square/)  |   Medium   |  √   |      |
| 496  | [下一个更大元素 I](https://leetcode.cn/problems/next-greater-element-i/) |    Easy    |  √   |      |
| 503  | [下一个更大元素 II](https://leetcode.cn/problems/next-greater-element-ii/) |   Medium   |  √   |      |
| 581  | [最短无序连续子数组](https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/) |   Medium   |  √   |      |
| 739  | [每日温度](https://leetcode.cn/problems/daily-temperatures/) |   Medium   |  √   |      |
| 769  | [最多能完成排序的块](https://leetcode.cn/problems/max-chunks-to-make-sorted/) |   Medium   |  √   |      |

## 数组

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 15   |        [三数之和](https://leetcode.cn/problems/3sum/)        |   Medium   |  √   |      |
| 26   | [删除有序数组中的重复项](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/) |    Easy    |  √   |      |
| 27   |   [移除元素](https://leetcode.cn/problems/remove-element/)   |    Easy    |  √   |      |
| 34   | [在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/) |   Medium   |  √   |      |
| 35   | [搜索插入位置](https://leetcode.cn/problems/search-insert-position/) |    Easy    |  √   |      |
| 36   |   [有效的数独](https://leetcode.cn/problems/valid-sudoku/)   |   Medium   |  √   |      |
| 48   |    [旋转图像](https://leetcode.cn/problems/rotate-image/)    |   Medium   |  √   |      |
| 66   |        [加一](https://leetcode.cn/problems/plus-one/)        |    Easy    |  √   |      |
| 167  | [两数之和 II - 输入有序数组](https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/) |   Medium   |  √   |      |
| 219  | [存在重复元素 II](https://leetcode.cn/problems/contains-duplicate-ii/) |    Easy    |  √   |      |
| 283  |     [移动零](https://leetcode.cn/problems/move-zeroes/)      |    Easy    |  √   |  √   |
| 448  | [找到所有数组中消失的数字](https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/) |    Easy    |  √   |  √   |
| 674  | [最长连续递增序列](https://leetcode.cn/problems/longest-continuous-increasing-subsequence/) |    Easy    |      |  √   |
| 704  |    [二分查找](https://leetcode.cn/problems/binary-search)    |    Easy    |  √   |      |
| 717  | [1比特与2比特字符](https://leetcode.cn/problems/1-bit-and-2-bit-characters/) |    Easy    |  √   |      |
| 747  | [至少是其他数字两倍的最大数](https://leetcode.cn/problems/largest-number-at-least-twice-of-others/) |    Easy    |  √   |      |
| 986  | [区间列表的交集](https://leetcode.cn/problems/interval-list-intersections/) |   Medium   |      |  √   |
| 1282 | [用户分组](https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/) |   Medium   |  √   |      |
| 1450 | [在既定时间做作业的学生人数](https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/) |    Easy    |  √   |      |
| 1725 | [可以形成最大正方形的矩形数目](https://leetcode.cn/problems/number-of-rectangles-that-can-form-the-largest-square/) |    Easy    |  √   |      |
| 1748 | [唯一元素的和](https://leetcode.cn/problems/sum-of-unique-elements/) |    Easy    |  √   |      |
| 1984 | [学生分数的最小差值](https://leetcode.cn/problems/minimum-difference-between-highest-and-lowest-of-k-scores/) |    Easy    |  √   |      |
| 2006 | [差的绝对值为 K 的数对数目](https://leetcode.cn/problems/count-number-of-pairs-with-absolute-difference-k/) |    Easy    |  √   |      |
| 2013 |  [检测正方形](https://leetcode.cn/problems/detect-squares/)  |   Medium   |  √   |      |
| 2016 | [增量元素之间的最大差值](https://leetcode.cn/problems/maximum-difference-between-increasing-elements/) |    Easy    |  √   |      |
| 2022 | [将一维数组转变成二维数组](https://leetcode.cn/problems/convert-1d-array-into-2d-array/) |    Easy    |  √   |      |
| 2099 | [找到和最大的长度为 K 的子序列](https://leetcode.cn/problems/find-subsequence-of-length-k-with-the-largest-sum/) |    Easy    |  √   |      |
| 2104 | [子数组范围和](https://leetcode.cn/problems/sum-of-subarray-ranges/) |   Medium   |  √   |  √   |
| 2125 | [银行中的激光束数量](https://leetcode.cn/problems/number-of-laser-beams-in-a-bank/) |   Medium   |  √   |      |
| 2148 | [元素计数](https://leetcode.cn/problems/count-elements-with-strictly-smaller-and-greater-elements/) |    Easy    |  √   |      |
| 2150 | [找出数组中的所有孤独数字](https://leetcode.cn/problems/find-all-lonely-numbers-in-the-array/) |   Medium   |  √   |      |
| 2154 | [将找到的值乘以 2](https://leetcode.cn/problems/keep-multiplying-found-values-by-two/) |    Easy    |  √   |      |
| 2155 | [分组得分最高的所有下标](https://leetcode.cn/problems/all-divisions-with-the-highest-score-of-a-binary-array/) |   Medium   |  √   |      |
| 2176 | [统计数组中相等且可以被整除的数对](https://leetcode.cn/problems/count-equal-and-divisible-pairs-in-an-array/) |    Easy    |  √   |      |
| 2190 | [数组中紧跟 key 之后出现最频繁的数字](https://leetcode.cn/problems/most-frequent-number-following-key-in-an-array/) |    Easy    |  √   |      |
| 2206 | [将数组划分成相等数对](https://leetcode.cn/problems/divide-array-into-equal-pairs/) |    Easy    |  √   |      |
| 2210 | [统计数组中峰和谷的数量](https://leetcode.cn/problems/count-hills-and-valleys-in-an-array/) |    Easy    |  √   |      |

## 二分

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 33   | [搜索旋转排序数组](https://leetcode.cn/problems/search-in-rotated-sorted-array/) |   Medium   |  √   |      |
| 540  | [有序数组中的单一元素](https://leetcode.cn/problems/single-element-in-a-sorted-array/) |   Medium   |  √   |      |
| 704  |    [二分查找](https://leetcode.cn/problems/binary-search)    |    Easy    |  √   |      |
| 744  | [寻找比目标字母大的最小字母](https://leetcode.cn/problems/find-smallest-letter-greater-than-target/) |    Easy    |  √   |  √   |

## 动态规划

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 53   | [最大子数组和](https://leetcode.cn/problems/maximum-subarray/) |    Easy    |  √   |  √   |
| 121  | [买卖股票的最佳时机](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock) |    Easy    |  √   |      |
| 152  | [乘积最大子数组](https://leetcode.cn/problems/maximum-product-subarray/) |   Medium   |  √   |  √   |
| 913  |   [猫和老鼠](https://leetcode.cn/problems/cat-and-mouse/)    |    Hard    |  √   |      |
| 1220 | [统计元音字母序列的数目](https://leetcode.cn/problems/count-vowels-permutation/) |    Hard    |  √   |      |
| 1277 | [统计全为 1 的正方形子矩阵](https://leetcode.cn/problems/count-square-submatrices-with-all-ones/) |   Medium   |  √   |      |
| 2100 | [适合打劫银行的日子](https://leetcode.cn/problems/find-good-days-to-rob-the-bank/) |   Medium   |  √   |  √   |

根据 [Dynamic Programming Patterns](https://leetcode.com/discuss/general-discussion/458695/dynamic-programming-patterns) 将动态规划分为以下几类:

1. 到达目标值的最大(最小)路径

   描述:

   给一个目标值, 找到到达该目标值的最大(最小)花费 / 路径 / 和

   解法:

   在所有可能的路径中找到达到当前状态的最大(最小)路径, 再加一个值作为当前状态

   | ID   |                            Title                             | Difficulty | Java |  Go  |
   | :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
   | 64   | [最小路径和](https://leetcode.cn/problems/minimum-path-sum/) |   Medium   |  √   |      |
   | 322  |    [零钱兑换](https://leetcode.cn/problems/coin-change/)     |   Medium   |  √   |      |
   | 746  | [使用最小花费爬楼梯](https://leetcode.cn/problems/min-cost-climbing-stairs/) |    Easy    |  √   |      |

## BFS

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 127  |     [单词接龙](https://leetcode.cn/problems/word-ladder)     |    Hard    |  √   |      |
| 1034 |  [边界着色](https://leetcode.cn/problems/coloring-a-border)  |   Medium   |  √   |      |
| 1036 | [逃离大迷宫](https://leetcode.cn/problems/escape-a-large-maze/) |    Hard    |  √   |      |
| 1345 |  [跳跃游戏 IV](https://leetcode.cn/problems/jump-game-iv/)   |    Hard    |  √   |      |
| 1765 | [地图中的最高点](https://leetcode.cn/problems/map-of-highest-peak/) |   Medium   |  √   |      |
| 2146 | [统计隐藏数组数目](https://leetcode.cn/problems/count-the-hidden-sequences/) |   Medium   |  √   |      |

## DFS

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 79   |    [单词搜索](https://leetcode.cn/problems/word-search/)     |   Medium   |  √   |      |
| 200  | [岛屿数量](https://leetcode.cn/problems/number-of-islands/)  |   Medium   |  √   |      |
| 329  | [矩阵中的最长递增路径](https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/) |    Hard    |      |  √   |
| 386  | [字典序排数](https://leetcode.cn/problems/lexicographical-numbers/) |   Medium   |  √   |      |
| 463  | [岛屿的周长](https://leetcode.cn/problems/island-perimeter/) |    Easy    |  √   |      |
| 695  | [岛屿的最大面积](https://leetcode.cn/problems/max-area-of-island/) |   Medium   |  √   |  √   |
| 1020 | [飞地的数量](https://leetcode.cn/problems/number-of-enclaves/) |   Medium   |  √   |      |
| 1219 | [黄金矿工](https://leetcode.cn/problems/path-with-maximum-gold/) |   Medium   |  √   |      |
| 1254 | [统计封闭岛屿的数目](https://leetcode.cn/problems/number-of-closed-islands/) |   Medium   |  √   |      |
| 1905 | [统计子岛屿](https://leetcode.cn/problems/count-sub-islands/) |   Medium   |  √   |      |

## 位运算

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 136  | [只出现一次的数字](https://leetcode.cn/problems/single-number) |    Easy    |  √   |      |
| 260  | [只出现一次的数字 III](https://leetcode.cn/problems/single-number-iii) |   Medium   |  √   |      |
| 268  |  [丢失的数字](https://leetcode.cn/problems/missing-number)   |    Easy    |  √   |      |
| 461  |  [汉明距离](https://leetcode.cn/problems/hamming-distance/)  |    Easy    |  √   |  √   |
| 540  | [有序数组中的单一元素](https://leetcode.cn/problems/single-element-in-a-sorted-array/) |   Medium   |  √   |      |
| 693  | [交替位二进制数](https://leetcode.cn/problems/binary-number-with-alternating-bits/) |    Easy    |  √   |      |
| 2166 |   [设计位集](https://leetcode.cn/problems/design-bitset/)    |   Medium   |  √   |      |
| 2220 | [转换数字的最少位翻转次数](https://leetcode.cn/problems/minimum-bit-flips-to-convert-number/) |    Easy    |  √   |      |

## 数学

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 7    |  [整数反转](https://leetcode.cn/problems/reverse-integer/)   |    Easy    |  √   |      |
| 9    |  [回文数](https://leetcode.cn/problems/palindrome-number/)   |    Easy    |  √   |      |
| 31   | [下一个排列](https://leetcode.cn/problems/next-permutation/) |   Medium   |  √   |      |
| 89   |     [格雷编码](https://leetcode.cn/problems/gray-code/)      |   Medium   |  √   |      |
| 172  | [阶乘后的零](https://leetcode.cn/problems/factorial-trailing-zeroes/) |   Medium   |  √   |  √   |
| 258  |     [各位相加](https://leetcode.cn/problems/add-digits/)     |    Easy    |  √   |      |
| 292  |      [Nim 游戏](https://leetcode.cn/problems/nim-game)       |    Easy    |  √   |      |
| 326  |    [3 的幂](https://leetcode.cn/problems/power-of-three)     |    Easy    |  √   |      |
| 539  | [最小时间差](https://leetcode.cn/problems/minimum-time-difference/) |   Medium   |  √   |      |
| 382  | [链表随机节点](https://leetcode.cn/problems/linked-list-random-node/) |   Medium   |  √   |      |
| 390  |  [消除游戏](https://leetcode.cn/problems/elimination-game/)  |   Medium   |  √   |      |
| 504  |       [七进制数](https://leetcode.cn/problems/base-7/)       |    Easy    |  √   |      |
| 507  |    [完美数](https://leetcode.cn/problems/perfect-number/)    |    Easy    |  √   |      |
| 537  | [复数乘法](https://leetcode.cn/problems/complex-number-multiplication/) |   Medium   |  √   |      |
| 553  |  [最优除法](https://leetcode.cn/problems/optimal-division/)  |   Medium   |  √   |  √   |
| 650  | [只有两个键的键盘](https://leetcode.cn/problems/2-keys-keyboard) |   Medium   |  √   |      |
| 1154 | [一年中的第几天](https://leetcode.cn/problems/day-of-the-year/) |    Easy    |  √   |      |
| 1185 | [一周中的第几天](https://leetcode.cn/problems/day-of-the-week/) |    Easy    |  √   |      |
| 1447 | [最简分数](https://leetcode.cn/problems/simplified-fractions/) |   Medium   |  √   |      |
| 1688 | [比赛中的配对次数](https://leetcode.cn/problems/count-of-matches-in-tournament/) |    Easy    |  √   |      |
| 1716 | [计算力扣银行的钱](https://leetcode.cn/problems/calculate-money-in-leetcode-bank/) |    Easy    |  √   |      |
| 2001 | [可互换矩形的组数](https://leetcode.cn/problems/number-of-pairs-of-interchangeable-rectangles) |   Medium   |  √   |      |
| 2011 | [执行操作后的变量值](https://leetcode.cn/problems/final-value-of-variable-after-performing-operations) |    Easy    |  √   |      |
| 2029 |  [石子游戏 IX](https://leetcode.cn/problems/stone-game-ix/)  |   Medium   |  √   |      |
| 2038 | [如果相邻两个颜色均相同则删除当前颜色](https://leetcode.cn/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/) |   Medium   |  √   |  √   |
| 2110 | [股票平滑下跌阶段的数目](https://leetcode.cn/problems/number-of-smooth-descent-periods-of-a-stock/) |   Medium   |  √   |      |
| 2119 | [反转两次的数字](https://leetcode.cn/problems/a-number-after-a-double-reversal/) |    Easy    |  √   |      |
| 2177 | [找到和为给定整数的三个连续整数](https://leetcode.cn/problems/find-three-consecutive-integers-that-sum-to-a-given-number/) |   Medium   |  √   |      |

## 枚举

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 647  | [回文子串](https://leetcode.cn/problems/palindromic-substrings/) |   Medium   |  √   |      |
| 2094 | [找出 3 位偶数](https://leetcode.cn/problems/finding-3-digit-even-numbers) |    Easy    |  √   |      |

## 模拟

| ID   |                            Title                             | Difficulty | Java |  Go  |
| :--- | :----------------------------------------------------------: | :--------: | :--: | :--: |
| 12   | [整数转罗马数字](https://leetcode.cn/problems/integer-to-roman/) |   Medium   |  √   |      |
| 13   | [罗马数字转整数](https://leetcode.cn/problems/roman-to-integer/) |    Easy    |  √   |      |
| 258  |     [各位相加](https://leetcode.cn/problems/add-digits/)     |    Easy    |  √   |  √   |
| 393  | [UTF-8 编码验证](https://leetcode.cn/problems/utf-8-validation/) |   Medium   |  √   |      |
| 504  |       [七进制数](https://leetcode.cn/problems/base-7/)       |    Easy    |  √   |  √   |
| 640  | [求解方程](https://leetcode.cn/problems/solve-the-equation/) |   Medium   |  √   |      |
| 682  |   [棒球比赛](https://leetcode.cn/problems/baseball-game/)    |    Easy    |  √   |  √   |
| 693  | [交替位二进制数](https://leetcode.cn/problems/binary-number-with-alternating-bits/) |    Easy    |  √   |  √   |
| 762  | [二进制表示中质数个计算置位](https://leetcode.cn/problems/prime-number-of-set-bits-in-binary-representation/) |    Easy    |  √   |  √   |
| 794  | [有效的井字游戏](https://leetcode.cn/problems/valid-tic-tac-toe-state/) |   Medium   |  √   |      |
| 806  | [写字符串需要的行数](https://leetcode.cn/problems/number-of-lines-to-write-string/) |    Easy    |  √   |  √   |
| 838  |   [推多米诺](https://leetcode.cn/problems/push-dominoes/)    |   Medium   |  √   |      |
| 997  | [找到小镇的法官](https://leetcode.cn/problems/find-the-town-judge/) |    Easy    |  √   |      |
| 1342 | [将数字变成 0 的操作次数](https://leetcode.cn/problems/number-of-steps-to-reduce-a-number-to-zero/) |    Easy    |  √   |      |
| 1518 |   [换酒问题](https://leetcode.cn/problems/water-bottles/)    |    Easy    |  √   |      |
| 1995 | [统计特殊四元组](https://leetcode.cn/problems/count-special-quadruplets/) |    Easy    |  √   |      |
| 2028 | [找出缺失的观测数据](https://leetcode.cn/problems/find-missing-observations/) |   Medium   |  √   |  √   |
| 2043 | [简易银行系统](https://leetcode.cn/problems/simple-bank-system/) |   Medium   |  √   |  √   |
| 2103 |    [环和杆](https://leetcode.cn/problems/rings-and-rods/)    |    Easy    |  √   |      |
| 2105 | [给植物浇水 II](https://leetcode.cn/problems/watering-plants-ii/) |   Medium   |  √   |      |
| 2120 | [执行所有后缀指令](https://leetcode.cn/problems/execution-of-all-suffix-instructions-staying-in-a-grid/) |   Medium   |  √   |      |
| 2162 | [设置时间的最少代价](https://leetcode.cn/problems/minimum-cost-to-set-cooking-time/) |   Medium   |  √   |      |
| 2169 | [得到 0 的操作数](https://leetcode.cn/problems/count-operations-to-obtain-zero/) |    Easy    |  √   |      |
| 2180 | [统计各位数字之和为偶数的整数个数](https://leetcode.cn/problems/count-integers-with-even-digit-sum/) |    Easy    |  √   |      |
| 2194 | [Excel 表中某个范围内的单元格](https://leetcode.cn/problems/cells-in-a-range-on-an-excel-sheet/) |    Easy    |  √   |      |
| 2211 | [统计道路上的碰撞次数](https://leetcode.cn/problems/count-collisions-on-a-road/) |   Medium   |  √   |      |
| 2221 | [数组的三角和](https://leetcode.cn/problems/find-triangular-sum-of-an-array/) |   Medium   |  √   |      |
