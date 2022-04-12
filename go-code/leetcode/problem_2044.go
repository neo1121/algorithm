package main

func countMaxOrSubsets(nums []int) int {
	max := 0
	for _, v := range nums {
		max |= v
	}
	return process(nums, 0, 0, max)
}

func process(nums []int, index int, cur int, tar int) int {
	if index == len(nums) {
		if cur == tar {
			return 1
		} else {
			return 0
		}
	}
	cnt := 0
	cnt += process(nums, index+1, cur, tar)
	cnt += process(nums, index+1, cur|nums[index], tar)
	return cnt
}
