package problem_504

import (
	"strconv"
)

func convertToBase7(num int) string {
	if num == 0 {
		return "0"
	}
	temp := num
	if temp < 0 {
		temp = -temp
	}
	var ans string
	for temp > 0 {
		ans = strconv.Itoa(temp%7) + ans
		temp /= 7
	}
	if num < 0 {
		ans = "-" + ans
	}
	return ans
}
