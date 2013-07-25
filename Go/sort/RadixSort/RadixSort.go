package main

import (
	"container/list"
	"fmt"
	"math"
)

func radixSort(array []int) {
	//确定数列中的最大值
	max := array[0]
	for _, v := range array {
		if v > max {
			max = v
		}
	}
	//判断位数
	d := 0
	for max > 0 {
		max /= 10
		d++
	}

	var queue [10]*list.List
	for i := 0; i < 10; i++ {
		queue[i] = list.New()
	}

	for i := 0; i < d; i++ {

		for j := 0; j < len(array); j++ {
			//获取第i+1位的数字，通过余数计算出来
			p := int(math.Pow10(i + 1))
			q := int(math.Pow10(i))
			x := array[j] % p / q

			queue[x].PushBack(array[j])
		}

		count := 0
		for k := 0; k < 10; k++ {
			for e := queue[k].Front(); e != nil; e = e.Next() {
				array[count] = e.Value.(int)
				count++
			}
			queue[k].Init()
		}
	}

}

func main() {
	array := []int{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12,
		64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51}
	fmt.Println("排序前的数组是：", array)
	radixSort(array)
	fmt.Println("排序后的数组是：", array)
}
