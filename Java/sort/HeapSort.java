package sort;

import java.util.Arrays;

//堆排序是一种树形选择排序方法，它的特点是，在排序过程中将R[1..n]看成是一棵完全二叉树的顺序存储结构，利用完全二叉树中双亲节点和孩子节点的内在关系，
//在当前无序区中选择关键字最大（或最小）的记录。

//堆排序是选择排序的一种，不稳定，平均时间复杂度O(nlog2n)，空间复杂度O(1)，建立堆的时间为O(n)
//由于建初始堆所需的比较次数较多，所以堆排序不适合于记录数较少的表
public class HeapSort {

	// 调整最大堆
	public static void sift(int[] array, int low, int high) {
		int i = low, j = 2 * (i + 1) - 1; // i为父节点，2*(i+1)-1为左孩子节点
		int tmp = array[i];
		while (j <= high) {
			if (j < high && array[j] < array[j + 1]) { // 取孩子节点中最大值
				j++;
			}
			if (tmp < array[j]) { // 小于这时array[j]的值，说明tmp这个值放入这里无法构成大根堆，需要继续向下搜索
				array[i] = array[j];
				i = j;
				j = 2 * (i + 1) - 1;
			} else {
				break;
			}
		}
		array[i] = tmp; // 被筛选的值放入最终位置
	}

	public static void heapSort(int[] array) {
		int len = array.length, i, tmp;
		for (i = (len - 1) / 2; i >= 0; i--) {
			sift(array, i, len - 1); // 从数组的中间开始，向上筛选，建立最大堆
		}
		for (i = len - 1; i >= 1; i--) {
			tmp = array[0]; // 最大堆第一个为数组最大值
			array[0] = array[i];
			array[i] = tmp; // 最大值放入最终排序位置
			sift(array, 0, i - 1); // 将最后一个位置的值放到第一个，可能破坏堆，需要调整一次
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4,
				62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };

		System.out.println("排序前的数组是：" + Arrays.toString(array));
		long before = System.nanoTime();
		heapSort(array);
		long after = System.nanoTime();
		System.out.println("排序后的数组是：" + Arrays.toString(array));
		System.out.println("排序过程耗时：" + (after - before) + "纳秒");
	}

}
