package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort {

	public static void radixSort(int[] array) {
		// 首先确定排序的趟数
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		// 判断位数
		int time = 0;
		while (max > 0) {
			max /= 10;
			time++;
		}

		// 建立10个队列
		List<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 10; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			queue.add(list);
		}
		// 进行time次分配和收集
		for (int i = 0; i < time; i++) {
			// 分配数组元素
			for (int j = 0; j < array.length; j++) {
				// 得到数字的第i+1位数
				int x = array[j] % (int) Math.pow(10, i + 1)
						/ (int) Math.pow(10, i);
				ArrayList<Integer> list = queue.get(x);
				list.add(array[j]);
				// queue.set(x, list);
			}
			// 收集队列元素
			int count = 0;
			for (int k = 0; k < 10; k++) {
				while (queue.get(k).size() > 0) {
					ArrayList<Integer> list = queue.get(k);
					array[count] = list.get(0);
					list.remove(0);
					count++;
				}
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int array[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4,
				62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };

		System.out.println("排序前的数组是：" + Arrays.toString(array));
		long before = System.nanoTime();
		radixSort(array);
		long after = System.nanoTime();
		System.out.println("排序后的数组是：" + Arrays.toString(array));
		System.out.println("排序过程耗时：" + (after - before) + "纳秒");
	}

}
