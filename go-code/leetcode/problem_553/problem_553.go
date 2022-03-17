package problem_553

import "strconv"

func optimalDivision(nums []int) string {
	if len(nums) == 1 {
		return strconv.Itoa(nums[0])
	} else if len(nums) == 2 {
		return strconv.Itoa(nums[0]) + "/" + strconv.Itoa(nums[1])
	}
	ans := ""
	for i, num := range nums {
		if i == 1 {
			ans += "("
		}
		ans += strconv.Itoa(num)
		if i != len(nums)-1 {
			ans += "/"
		} else {
			ans += ")"
		}
	}
	return ans
}
