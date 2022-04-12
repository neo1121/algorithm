package main

func numberOfLines(widths []int, s string) []int {
	line := 1
	lastWidth := 0
	for i, len := 0, len(s); i < len; i++ {
		byteWidth := widths[s[i]-'a']
		if lastWidth+byteWidth > 100 {
			line += 1
			lastWidth = byteWidth
		} else {
			lastWidth += byteWidth
		}
	}
	return []int{line, lastWidth}
}
