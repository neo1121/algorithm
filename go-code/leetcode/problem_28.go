package main

func strStr(haystack string, needle string) int {
	if len(needle) == 0 {
		return 0
	}
	next := getNextArr(needle)
	i := 0
	j := 0
	for i < len(haystack) && j < len(needle) {
		if haystack[i] == needle[j] {
			i += 1
			j += 1
		} else if j == 0 {
			i += 1
		} else {
			j = next[j]
		}
	}
	if j == len(needle) {
		return i - j
	} else {
		return -1
	}
}

func getNextArr(s string) []int {
	if len(s) == 1 {
		return []int{-1}
	}
	next := make([]int, len(s))
	next[0] = -1
	next[1] = 0
	i := 2
	p := 0
	for i < len(s) {
		if s[i-1] == s[p] {
			next[i] = p + 1
			i += 1
			p += 1
		} else if p > 0 {
			p = next[p]
		} else {
			next[i] = 0
			i += 1
		}
	}
	return next
}
