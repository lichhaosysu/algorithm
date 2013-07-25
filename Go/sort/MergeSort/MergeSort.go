package main

import (
	"fmt"
)

func merge(R []int, low, mid, high int) {
	size := high - low + 1
	i, j, k := low, mid+1, 0
	R1 := make([]int, size)

	for i <= mid && j <= high {
		if R[i] < R[j] {
			R1[k] = R[i]
			i++
			k++
		} else {
			R1[k] = R[j]
			j++
			k++
		}
	}
	for i <= mid {
		R1[k] = R[i]
		i++
		k++
	}
	for j <= high {
		R1[k] = R[j]
		j++
		k++
	}
	k = 0
	for i = low; i <= high; i++ {
		R[i] = R1[k]
		k++
	}

}

func mergePass(R []int, length, n int) {
	var i int
	for i = 0; i+2*length-1 < n; i = i + 2*length {
		merge(R, i, i+length-1, i+2*length-1)
	}
	if i+length-1 < n {
		merge(R, i, i+length-1, n-1)
	}
}

func mergeSort(R []int, n int) {
	for length := 1; length < n; length = 2 * length {
		mergePass(R, length, n)
	}
}

func mergeSortDC(R []int, low, high int) {
	var mid int
	if low < high {
		mid = (low + high) / 2
		mergeSortDC(R, low, mid)
		mergeSortDC(R, mid+1, high)
		merge(R, low, mid, high)
	}
}

func main() {

	array := []int{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12,
		64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51}
	fmt.Println("使用自底向上方法进行二路归并排序：")
	fmt.Println("排序前的数组是：", array)
	mergeSort(array, len(array))
	fmt.Println("排序后的数组是：", array)

	array = []int{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12,
		64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51}
	fmt.Println("使用自顶向下方法进行二路归并排序：")
	fmt.Println("排序前的数组是：", array)
	mergeSortDC(array, 0, len(array)-1)
	fmt.Println("排序后的数组是：", array)
}
