package main

import (
	"fmt"
)

//使用了golang中的slice来实现数组修改
func bubbleSort(array []int) {
	n := len(array)
	for i := 0; i < n-1; i++ {
		for j := n - 1; j > i; j-- {
			if array[j] < array[j-1] {
				array[j], array[j-1] = array[j-1], array[j]
			}
		}
	}
}

func main() {
	array := []int{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12,
		64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51}
	fmt.Println("排序前的数组是：", array)
	bubbleSort(array)
	fmt.Println("排序后的数组是：", array)
}
