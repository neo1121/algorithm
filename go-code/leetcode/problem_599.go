package leetcode

func findRestaurant(list1 []string, list2 []string) []string {
	indexMap := map[string]int{}
	for i, v := range list2 {
		indexMap[v] = i
	}
	ans := []string{}
	minIndexSum := 2000
	for i, v := range list1 {
		if index, ok := indexMap[v]; ok {
			if i+index < minIndexSum {
				ans = []string{v}
				minIndexSum = i + index
			} else if i+index == minIndexSum {
				ans = append(ans, v)
			}
		}
	}
	return ans
}
