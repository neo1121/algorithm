package problem_357

var ans int

func countNumbersWithUniqueDigits(n int) int {
	ans = 0
	process(0, 0, n)
	return ans + 1
}

func process(r int, size int, n int) {
	if size == n {
		return
	}
	var i int
	if size > 0 {
		i = 0
	} else {
		i = 1
	}
	for ; i < 10; i++ {
		t := 1 << i
		if r&t == 0 {
			ans += 1
			process(r|t, size+1, n)
		}
	}
}
