package main

func rotateString(s string, goal string) bool {
	if len(s) != len(goal) {
		return false
	}
	s += s
	for i, len := 0, len(goal); i < len; i++ {
		if s[i] == goal[0] && s[i:i+len] == goal {
			return true
		}
	}
	return false
}
