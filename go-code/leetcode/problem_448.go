package main

import "math"

func findDisappearedNumbers(nums []int) []int {
	for _, v := range nums {
		index := int(math.Abs(float64(v))) - 1
		if nums[index] > 0 {
			nums[index] = -nums[index]
		}
	}
	var ans []int
	for i, v := range nums {
		if v > 0 {
			ans = append(ans, i+1)
		}
	}
	return ans
}
