package problem_392

func isSubsequence(s string, t string) bool {
	i := 0
	for j := 0; j < len(t) && i < len(s); j++ {
		if t[j] == s[i] {
			i++
		}
	}
	return i == len(s)
}
