package problem_152

func maxProduct(nums []int) int {
	ans := nums[0]
	max := nums[0]
	min := nums[0]
	for i, len := 1, len(nums); i < len; i++ {
		v := nums[i]
		if v < 0 {
			max, min = min, max
		}
		if max*v > v {
			max *= v
		} else {
			max = v
		}
		if min*v < v {
			min *= v
		} else {
			min = v
		}
		if max > ans {
			ans = max
		}
	}
	return ans
}
