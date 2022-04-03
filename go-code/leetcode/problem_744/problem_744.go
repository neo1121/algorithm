package problem_744

func nextGreatestLetter(letters []byte, target byte) byte {
	index := binarySearch(letters, 0, len(letters)-1, target)
	if index == -1 {
		return letters[0]
	} else {
		return letters[index]
	}
}

func binarySearch(letters []byte, l int, r int, target byte) int {
	if l > r {
		return -1
	}
	m := l + (r-l)/2
	if letters[m] <= target {
		return binarySearch(letters, m+1, r, target)
	} else {
		t := binarySearch(letters, l, m-1, target)
		if t == -1 {
			return m
		} else {
			return t
		}
	}
}
