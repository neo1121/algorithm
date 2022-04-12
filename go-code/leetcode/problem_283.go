package main

func moveZeroes(nums []int) {
	for zeroIndex, nonZeroIndex, len := 0, 0, len(nums); zeroIndex < len && nonZeroIndex < len; nonZeroIndex++ {
		if nums[nonZeroIndex] != 0 {
			nums[nonZeroIndex], nums[zeroIndex] = nums[zeroIndex], nums[nonZeroIndex]
			zeroIndex += 1
		}
	}
}
