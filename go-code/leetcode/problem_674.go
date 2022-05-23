package main

func findLengthOfLCIS(nums []int) int {
	ret := 0
	cache := 0
	preNum := 0
	for _, v := range nums {
		if v > preNum {
			cache += 1
		} else {
			if cache > ret {
				ret = cache
			}
			cache = 1
		}
		preNum = v
	}
	if cache > ret {
		return cache
	}
	return ret
}
