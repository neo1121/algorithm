package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var sum int
var deepestLevel int

func process(node *TreeNode, level int) {
	if node == nil {
		return
	}
	if level > deepestLevel {
		deepestLevel = level
		sum = node.Val
	} else if level == deepestLevel {
		sum += node.Val
	}
	process(node.Left, level+1)
	process(node.Right, level+1)
}

func deepestLeavesSum(root *TreeNode) int {
	sum = 0
	deepestLevel = 0
	process(root, 0)
	return sum
}
