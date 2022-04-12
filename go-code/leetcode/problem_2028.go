package main

func missingRolls(rolls []int, mean int, n int) []int {
	m := len(rolls)
	sum := 0
	for _, v := range rolls {
		sum += v
	}
	sum = (m+n)*mean - sum
	ans := make([]int, n)
	rest := sum % n
	sum /= n
	if sum > 6 || (sum == 6 && rest > 0) {
		return []int{}
	}
	for i := 0; i < n; i++ {
		ans[i] = sum
		if rest > 0 {
			if rest+sum <= 6 {
				ans[i] += rest
			} else {
				ans[i] = 6
			}
			rest -= 6 - sum
		}
	}
	return ans
}
