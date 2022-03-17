package problem_226

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func invertTree(root *TreeNode) *TreeNode {
	invert(root)
	return root
}

func invert(node *TreeNode) {
	if node == nil {
		return
	}
	left := node.Left
	right := node.Right
	invert(left)
	invert(right)
	node.Left = right
	node.Right = left
}
