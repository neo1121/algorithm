package main

type Node struct {
	Val      int
	Children []*Node
}

func levelOrder(root *Node) [][]int {
	ans := [][]int{}
	if root == nil {
		return ans
	}
	pNodes := []*Node{root}
	for len(pNodes) > 0 {
		vals := []int{}
		t := []*Node{}
		for _, pNode := range pNodes {
			vals = append(vals, (*pNode).Val)
			children := (*pNode).Children
			for _, pChild := range children {
				t = append(t, pChild)
			}
		}
		ans = append(ans, vals)
		pNodes = t
	}
	return ans
}
