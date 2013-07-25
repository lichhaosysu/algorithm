package main

import (
	"fmt"
)

func insertSort(array []int) {
	j, tmp := 0, 0
	for i := 1; i < len(array); i++ {
		j, tmp = i-1, array[i]
		for j >= 0 && tmp < array[j] {
			array[j+1] = array[j]
			j--
		}
		array[j+1] = tmp
	}
}

func main() {
	array := []int{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12,
		64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51}
	fmt.Println("排序前的数组是：", array)
	insertSort(array)
	fmt.Println("排序后的数组是：", array)
}
