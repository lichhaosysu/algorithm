package sort;

import java.util.Arrays;

public class ShellSort {

	public static void shellSort(int[] array) {
		int j = 0, temp = 0;
		int gap = array.length / 2;
 
		while (gap > 0) {
			for (int i = gap; i < array.length; i++) {
				temp = array[i];
				j = i - gap;
				while (j >= 0 && temp < array[j]) {
					array[j + gap] = array[j];
					j = j - gap;
				}
				array[j + gap] = temp;
			}
			gap = gap / 2;
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
		shellSort(array);
		long after = System.nanoTime();
		System.out.println("排序后的数组是：" + Arrays.toString(array));
		System.out.println("排序过程耗时：" + (after - before) + "纳秒");
	}

}
