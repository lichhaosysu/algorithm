package main

import (
	"fmt"
)

func shellSort(array []int) {
	var j int
	var tmp int
	gap := len(array) / 2

	for gap > 0 {
		for i := gap; i < len(array); i++ {
			tmp = array[i]
			j = i - gap
			for j >= 0 && tmp < array[j] {
				array[j+gap] = array[j]
				j = j - gap
			}
			array[j+gap] = tmp
		}
		gap = gap / 2
	}
}

func main() {
	array := []int{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12,
		64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51}
	fmt.Println("排序前的数组是：", array)
	shellSort(array)
	fmt.Println("排序后的数组是：", array)
}
