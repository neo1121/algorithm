package main

import "strconv"

func calPoints(ops []string) int {
	var arr []int
	for _, v := range ops {
		if v == "C" {
			arr = arr[0 : len(arr)-1]
		} else if v == "D" {
			arr = append(arr, arr[len(arr)-1]*2)
		} else if v == "+" {
			arr = append(arr, arr[len(arr)-1]+arr[len(arr)-2])
		} else {
			num, ok := strconv.Atoi(v)
			if ok == nil {
				arr = append(arr, num)
			}
		}
	}
	ans := 0
	for _, v := range arr {
		ans += v
	}
	return ans
}
