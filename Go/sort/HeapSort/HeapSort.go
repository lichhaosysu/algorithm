package main

//根据《数据结构》课本中算法实现的大根堆
/*
import (
	"fmt"
)

func sift(array []int, low int, high int) {
	i := low
	j := 2*(i+1) - 1
	tmp := array[i]
	for j <= high {
		if j < high && array[j] < array[j+1] {
			j++
		}
		if tmp < array[j] {
			array[i] = array[j]
			i, j = j, 2*(i+1)-1
		} else {
			break
		}
	}
	array[i] = tmp
}

func heapSort(array []int) {
	n := len(array)

	for i := (n - 1) / 2; i >= 0; i-- {
		sift(array, i, n-1)
	}

	for i := n - 1; i >= 1; i-- {
		array[0], array[i] = array[i], array[0]
		sift(array, 0, i-1)
	}
}

func main() {
	array := []int{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12,
		64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51}
	fmt.Println("排序前的数组是：", array)
	heapSort(array)
	fmt.Println("排序后的数组是：", array)
}
*/

//从Go源码中得到的int数组小根堆实现
import (
	"container/heap"
	"fmt"
)

// An IntHeap is a min-heap of ints.
type IntHeap []int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntHeap) Push(x interface{}) {
	// Push and Pop use pointer receivers because they modify the slice's length,
	// not just its contents.
	*h = append(*h, x.(int))
}

func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func main() {
	array := &IntHeap{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12,
		64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51}
	fmt.Println("排序前的数组是：", *array)
	heap.Init(array)
	fmt.Print("排序后的数组是：[")
	for array.Len() > 0 {
		fmt.Print(heap.Pop(array), " ")
	}
	fmt.Print("]")
}
