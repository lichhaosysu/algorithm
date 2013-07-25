package sort;

import java.util.Arrays;

public class InsertSort {

	public static void insertSort(int[] array) {
		int j = 0, temp = 0;
		for (int i = 1; i < array.length; i++) {
			j = i - 1;
			temp = array[i];
			while (j >= 0 && temp < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
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
		insertSort(array);
		long after = System.nanoTime();
		System.out.println("排序后的数组是：" + Arrays.toString(array));
		System.out.println("排序过程耗时："+(after-before)+"纳秒");

	}

}
