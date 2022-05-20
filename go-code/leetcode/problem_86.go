package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func partition(head *ListNode, x int) *ListNode {
	var sH, sT, bH, bT *ListNode
	for headCopy := head; headCopy != nil; headCopy = headCopy.Next {
		if headCopy.Val < x {
			if sH == nil {
				sH = headCopy
				sT = headCopy
			} else {
				sT.Next = headCopy
				sT = sT.Next
			}
		} else {
			if bH == nil {
				bH = headCopy
				bT = headCopy
			} else {
				bT.Next = headCopy
				bT = bT.Next
			}
		}
	}
	if bT != nil {
		bT.Next = nil
	}
	if sT != nil {
		sT.Next = bH
		return sH
	}
	return bH
}
