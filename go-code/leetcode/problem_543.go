package main

import (
	"math"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var ans int

func diameterOfBinaryTree(root *TreeNode) int {
	ans = 0
	dfs(root)
	return ans
}

func dfs(root *TreeNode) int {
	if root == nil {
		return 0
	}
	left := dfs((*root).Left)
	right := dfs((*root).Right)
	if left+right > ans {
		ans = left + right
	}
	return 1 + int(math.Max(float64(left), float64(right)))
}
