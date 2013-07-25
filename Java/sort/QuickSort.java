package sort;

import java.util.Arrays;

public class QuickSort {

	public static void quickSort(int[] array, int low, int high) {
		int i = low, j = high, temp = 0;
		/*
		 * 用来分隔序列的关键字，最后需要将其放入适当的位置，将整个序列划分成两部分
		 */
		if (low < high) {
			temp = array[low];
			while (i != j) {
				while (j > i && array[j] > temp) {
					j--;
				}
				array[i] = array[j];
				while (i < j && array[i] <= temp) {
					i++;
				}
				array[j] = array[i];
			}
			//将temp放到j的位置，将整个序列分隔为两部分
			//此时应有array[i]=array[j]，为了确保分隔正确，取后面的j(在j前的都比temp大)
			array[j] = temp;
			//递归分别对两个部分调用快速排序
			quickSort(array, low, j - 1);
			quickSort(array, j + 1, high);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = { 49, 38, 35, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4,
				62, 99, 98, 54, 56, 17, 18, 23, 34, 35, 35, 49, 53, 34 };

		System.out.println("排序前的数组是：" + Arrays.toString(array));
		long before = System.nanoTime();
		quickSort(array, 0, array.length - 1);
		long after = System.nanoTime();
		System.out.println("排序后的数组是：" + Arrays.toString(array));
		System.out.println("排序过程耗时：" + (after - before) + "纳秒");
	}

}
