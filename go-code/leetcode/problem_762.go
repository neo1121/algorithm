package main

import "math"

func countPrimeSetBits(left int, right int) int {
	ans := 0
	for ; left <= right; left++ {
		if isPrimeNumber(countOne(left)) {
			ans += 1
		}
	}
	return ans
}

func isPrimeNumber(num int) bool {
	if num == 1 {
		return false
	}
	for i, sqrt := 2, int(math.Sqrt(float64(num))); i <= sqrt; i++ {
		if num%i == 0 {
			return false
		}
	}
	return true
}

func countOne(num int) int {
	cnt := 0
	for num > 0 {
		if num&1 == 1 {
			cnt += 1
		}
		num >>= 1
	}
	return cnt
}
