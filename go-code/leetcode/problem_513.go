package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func process(node *TreeNode, level int) (int, int) {
	if node == nil {
		return -1, -1
	}
	if node.Left == nil && node.Right == nil {
		return node.Val, level
	}
	lVal, lLevel := process(node.Left, level+1)
	rVal, rLevel := process(node.Right, level+1)
	if lLevel >= rLevel {
		return lVal, lLevel
	} else {
		return rVal, rLevel
	}
}

func findBottomLeftValue(root *TreeNode) int {
	val, _ := process(root, 0)
	return val
}
