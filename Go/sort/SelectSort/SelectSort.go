package main

import (
	"fmt"
)

func selectSort(array []int) {
	n := len(array)
	var i, j, k int
	for i = 0; i < n-1; i++ {
		k = i
		for j = i + 1; j < n; j++ {
			if array[j] < array[k] {
				k = j
			}
		}
		if k != i {
			array[i], array[k] = array[k], array[i]
		}
	}
}

func main() {
	array := []int{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12,
		64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51}
	fmt.Println("排序前的数组是：", array)
	selectSort(array)
	fmt.Println("排序后的数组是：", array)
}
