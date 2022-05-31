package main

var m int
var n int
var mem [][]int

func dfs(matrix [][]int, i int, j int) int {
	if mem[i][j] > 0 {
		return mem[i][j]
	}
	curVal := matrix[i][j]
	nextLength := 0
	if i > 0 && matrix[i-1][j] > curVal {
		t := dfs(matrix, i-1, j)
		if t > nextLength {
			nextLength = t
		}
	}
	if i < m-1 && matrix[i+1][j] > curVal {
		t := dfs(matrix, i+1, j)
		if t > nextLength {
			nextLength = t
		}
	}
	if j < n-1 && matrix[i][j+1] > curVal {
		t := dfs(matrix, i, j+1)
		if t > nextLength {
			nextLength = t
		}
	}
	if j > 0 && matrix[i][j-1] > curVal {
		t := dfs(matrix, i, j-1)
		if t > nextLength {
			nextLength = t
		}
	}
	mem[i][j] = 1 + nextLength
	return 1 + nextLength
}

func longestIncreasingPath(matrix [][]int) int {
	m = len(matrix)
	n = len(matrix[0])
	mem = make([][]int, m)
	for i := 0; i < m; i++ {
		mem[i] = make([]int, n)
	}
	max := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			t := dfs(matrix, i, j)
			if t > max {
				max = t
			}
		}
	}
	return max
}
