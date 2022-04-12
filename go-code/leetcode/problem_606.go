package main

import (
	"strconv"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func tree2str(root *TreeNode) string {
	var ans string
	process(root, &ans)
	return ans[1 : len(ans)-1]
}

func process(root *TreeNode, s *string) {
	if root == nil {
		return
	}
	(*s) += "(" + strconv.Itoa((*root).Val)
	left := (*root).Left
	right := (*root).Right
	if left == nil && right != nil {
		(*s) += "()"
	} else {
		process(left, s)
	}
	process(right, s)
	(*s) += ")"
}
