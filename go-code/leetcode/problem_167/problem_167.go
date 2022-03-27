package problem_167

func twoSum(numbers []int, target int) []int {
	set := make([]int, 2001)
	for i, v := range numbers {
		need := target - v
		if set[hash(v)] > 0 {
			return []int{set[hash(v)], i + 1}
		}
		if need >= -1000 && need <= 1000 {
			set[hash(need)] = i + 1
		}
	}
	return []int{}
}

func hash(num int) int {
	return num + 1000
}
