package main

func hammingDistance(x int, y int) int {
	x ^= y
	ans := 0
	for ans > 0 {
		if (x & 1) == 0 {
			ans += 1
		}
		x = x >> 1
	}
	return ans
}
