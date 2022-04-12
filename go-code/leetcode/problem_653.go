package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func findTarget(root *TreeNode, k int) bool {
	if k < -20000 || k > 20000 {
		return false
	}
	set := make([]int, 20001)
	return dfs(root, set, k)
}

func dfs(root *TreeNode, set []int, k int) bool {
	if root == nil {
		return false
	}
	if set[hash((*root).Val)] > 0 {
		return true
	}
	need := hash(k - (*root).Val)
	if need >= 0 && need <= 20000 {
		set[need] += 1
	}
	return dfs((*root).Left, set, k) || dfs((*root).Right, set, k)
}

func hash(num int) int {
	return num + 10000
}
