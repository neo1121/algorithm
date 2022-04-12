package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func flatten(root *TreeNode) {
	cur := root
	for cur != nil {
		left := (*cur).Left
		if left == nil {
			cur = (*cur).Right
			continue
		}
		(*cur).Left = nil
		rightestOnLeft := left
		for (*rightestOnLeft).Right != nil {
			rightestOnLeft = (*rightestOnLeft).Right
		}
		(*rightestOnLeft).Right = (*cur).Right
		(*cur).Right = left
		cur = (*cur).Right
	}
}
