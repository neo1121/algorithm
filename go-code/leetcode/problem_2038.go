package main

func winnerOfGame(colors string) bool {
	aCount := 0
	bCount := 0
	for i, len := 1, len(colors); i < len-1; i++ {
		if colors[i-1] == colors[i] && colors[i] == colors[i+1] {
			if colors[i] == 'A' {
				aCount += 1
			} else {
				bCount += 1
			}
		}
	}
	return aCount > bCount
}
