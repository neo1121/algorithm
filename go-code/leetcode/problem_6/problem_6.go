package problem_6

func convert(s string, numRows int) string {
	if numRows == 1 {
		return s
	}
	strs := make([]string, numRows)
	index := 0
	f := true
	for i, len := 0, len(s); i < len; i++ {
		strs[index] += string(s[i])
		if f && index == numRows-1 {
			f = false
			index -= 1
		} else if f {
			index += 1
		} else if index == 0 {
			f = true
			index += 1
		} else {
			index -= 1
		}
	}
	ans := ""
	for _, v := range strs {
		println(v)
		ans += v
	}
	return ans
}
