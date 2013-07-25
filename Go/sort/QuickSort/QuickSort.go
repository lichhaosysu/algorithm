package main

import (
	"fmt"
)

/*
 * 用来分隔序列的关键字，最后需要将其放入适当的位置，将整个序列划分成两部分
 */
func quickSort(array []int, low int, high int) {
	i, j, tmp := low, high, 0
	if low < high {
		tmp = array[low]
		for i != j {
			for j > i && array[j] > tmp {
				j--
			}
			array[i] = array[j]
			for i < j && array[i] <= tmp {
				i++
			}
			array[j] = array[i]
		}
		//将temp放到j的位置，将整个序列分隔为两部分
		//此时应有array[i]=array[j]，为了确保分隔正确，取后面的j(在j前的都比temp大)
		array[j] = tmp
		//递归分别对两个部分调用快速排序
		quickSort(array, low, j-1)
		quickSort(array, j+1, high)
	}

}

func main() {
	array := []int{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12,
		64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51}
	fmt.Println("排序前的数组是：", array)
	quickSort(array, 0, len(array)-1)
	fmt.Println("排序后的数组是：", array)
}
