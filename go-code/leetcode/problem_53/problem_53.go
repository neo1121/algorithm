package problem_53

func maxSubArray(nums []int) int {
	dp := nums[0]
	max := nums[0]
	for i, len := 1, len(nums); i < len; i++ {
		if dp+nums[i] > nums[i] {
			dp += nums[i]
		} else {
			dp = nums[i]
		}
		if dp > max {
			max = dp
		}
	}
	return max
}
