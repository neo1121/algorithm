package main

func getIntersection(aLeft int, aRight int, bLeft int, bRight int) []int {
	if aLeft > bRight || aRight < bLeft {
		return nil
	}
	var left, right int
	if aLeft >= bLeft {
		left = aLeft
	} else {
		left = bLeft
	}
	if aRight <= bRight {
		right = aRight
	} else {
		right = bRight
	}
	return []int{left, right}
}

func intervalIntersection(firstList [][]int, secondList [][]int) [][]int {
	var ans [][]int
	firstLen := len(firstList)
	secondLen := len(secondList)
	for i, j := 0, 0; i < firstLen && j < secondLen; {
		a := firstList[i]
		b := secondList[j]
		aLeft := a[0]
		aRight := a[1]
		bLeft := b[0]
		bRight := b[1]
		intersection := getIntersection(aLeft, aRight, bLeft, bRight)
		if intersection != nil {
			ans = append(ans, intersection)
		}
		if aRight <= bRight {
			i += 1
		} else {
			j += 1
		}
	}
	return ans
}
