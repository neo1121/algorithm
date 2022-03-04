package leetcode

func subArrayRanges(nums []int) int64 {
	ans := (int64)(0)
	for i, v := range nums {
		max := v
		min := v
		for j, len := i+1, len(nums); j < len; j++ {
			if nums[j] > max {
				max = nums[j]
			} else if nums[j] < min {
				min = nums[j]
			}
			ans += (int64)(max - min)
		}
	}
	return ans
}
