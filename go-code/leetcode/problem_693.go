package main

// 模拟
func hasAlternatingBits(n int) bool {
	pre := -1
	for n > 0 {
		cur := n % 2
		if cur == pre {
			return false
		}
		pre = cur
		n /= 2
	}
	return true
}

// 位运算
func hasAlternatingBits2(n int) bool {
	n = n ^ (n >> 1)
	return (n & (n + 1)) == 0
}
