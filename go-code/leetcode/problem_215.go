package leetcode

func findKthLargest(nums []int, k int) int {
	mergeSort(nums)
	return nums[len(nums)-k]
}

func mergeSort(nums []int) {
	process(nums, 0, len(nums)-1)
}

func process(nums []int, l int, r int) {
	if l == r {
		return
	}
	m := l + (r-l)/2
	process(nums, l, m)
	process(nums, m+1, r)
	merge(nums, l, r, m)
}

func merge(nums []int, l int, r int, m int) {
	help := make([]int, r-l+1)
	index := 0
	i := l
	j := m + 1
	for i <= m && j <= r {
		if nums[i] <= nums[j] {
			help[index] = nums[i]
			i += 1
		} else {
			help[index] = nums[j]
			j += 1
		}
		index += 1
	}
	for ; i <= m; i, index = i+1, index+1 {
		help[index] = nums[i]
	}
	for ; j <= r; j, index = j+1, index+1 {
		help[index] = nums[j]
	}
	for i, len := 0, len(help); i < len; i++ {
		nums[l+i] = help[i]
	}
}
