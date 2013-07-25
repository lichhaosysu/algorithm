package sort;

import java.util.Arrays;

public class SelectSort {

	public static void selectSort(int[] array) {
		int len = array.length;
		int i, j, k, temp;
		for (i = 0; i < len - 1; i++) {
			k = i;
			for (j = i + 1; j < len; j++) {
				if (array[j] < array[k]) {
					k = j;
				}
			}
			if (k != i) {
				temp = array[i];
				array[i] = array[k];
				array[k] = temp;
			}
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
		selectSort(array);
		long after = System.nanoTime();
		System.out.println("排序后的数组是：" + Arrays.toString(array));
		System.out.println("排序过程耗时：" + (after - before) + "纳秒");
	}

}
