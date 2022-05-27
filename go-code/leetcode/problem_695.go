package main

var max, cur, m, n int

func inject(grid [][]int, x int, y int) {
	if x < 0 || x >= m {
		return
	}
	if y < 0 || y >= n {
		return
	}
	if grid[x][y] == 0 {
		return
	}
	cur += 1
	grid[x][y] = 0
	inject(grid, x-1, y)
	inject(grid, x, y-1)
	inject(grid, x, y+1)
	inject(grid, x+1, y)
}

func maxAreaOfIsland(grid [][]int) int {
	m = len(grid)
	n = len(grid[0])
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 0 {
				continue
			}
			inject(grid, i, j)
			if cur > max {
				max = cur
			}
			cur = 0
		}
	}
	return max
}
