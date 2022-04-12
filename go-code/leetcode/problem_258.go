package main

func addDigits(num int) int {
	for num > 9 {
		temp := 0
		for num > 0 {
			temp += num % 10
			num /= 10
		}
		num = temp
	}
	return num
}
