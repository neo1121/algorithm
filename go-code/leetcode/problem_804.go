package main

func uniqueMorseRepresentations(words []string) int {
	ans := 0
	r := make(map[string]bool)
	t := []string{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."}
	for _, word := range words {
		s := ""
		for i, len := 0, len(word); i < len; i++ {
			s += t[byte(word[i])-'a']
		}
		_, ok := r[s]
		if !ok {
			r[s] = true
			ans += 1
		}
	}
	return ans
}
