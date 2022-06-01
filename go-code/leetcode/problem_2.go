package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	root := &ListNode{}
	next := root
	v := 0
	for l1 != nil && l2 != nil {
		v += l1.Val + l2.Val
		next.Next = &ListNode{
			Val: v % 10,
		}
		v /= 10
		next = next.Next
		l1 = l1.Next
		l2 = l2.Next
	}
	for l1 != nil {
		v += l1.Val
		next.Next = &ListNode{
			Val: v % 10,
		}
		v /= 10
		next = next.Next
		l1 = l1.Next
	}
	for l2 != nil {
		v += l2.Val
		next.Next = &ListNode{
			Val: v % 10,
		}
		v /= 10
		next = next.Next
		l2 = l2.Next
	}
	if v > 0 {
		next.Next = &ListNode{
			Val: v,
		}
	}
	return root.Next
}
