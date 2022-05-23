package main

import "math"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func process(node *TreeNode, min int, max int) bool {
	if node == nil {
		return true
	}
	if node.Val <= min || node.Val >= max {
		return false
	}
	lBLT := process(node.Left, min, node.Val)
	rBLT := process(node.Right, node.Val, max)
	return lBLT && rBLT
}

func isValidBST(root *TreeNode) bool {
	return process(root, math.MinInt64, math.MaxInt64)
}
