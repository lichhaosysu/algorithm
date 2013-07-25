package sort;

import java.util.Arrays;

//归并排序时间复杂度无论在最好还是最坏情况下，都是O(nlog2n)
public class MergeSort {

	//一次归并的过程
	public static void Merge(int[] R, int low, int mid, int high) {
		int size = high - low + 1;
		int[] R1 = new int[size];

		int i = low, j = mid + 1, k = 0;

		while (i <= mid && j <= high) {
			if (R[i] <= R[j]) {
				R1[k] = R[i];
				i++;
				k++;
			} else {
				R1[k] = R[j];
				j++;
				k++;
			}
		}
		while (i <= mid) {
			R1[k] = R[i];
			i++;
			k++;
		}
		while (j <= high) {
			R1[k] = R[j];
			j++;
			k++;
		}

		for (k = 0, i = low; i <= high; k++, i++) {
			R[i] = R1[k];
		}

	}

	public static void MergePass(int[] R, int length, int n) {
		int i;
		for (i = 0; i + 2 * length - 1 < n; i = i + 2 * length) {
			Merge(R, i, i + length - 1, i + 2 * length - 1);
		}
		if (i + length - 1 < n) {
			Merge(R, i, i + length - 1, n - 1);
		}
	}

	public static void FromBottomToTopMergeSort(int[] R, int n) {
		for (int length = 1; length < n; length = 2 * length) {
			MergePass(R, length, n);
		}
	}

	public static void FromTopToBottomMergeSort(int[] R, int low, int high) {
		int mid = 0;
		if (low < high) {
			mid = (low + high) / 2;
			FromTopToBottomMergeSort(R, low, mid);
			FromTopToBottomMergeSort(R, mid + 1, high);
			Merge(R, low, mid, high);
		}
	}

	public static void main(String[] args) {
		int array[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4,
				62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };

		System.out.println("排序前的数组是：" + Arrays.toString(array));
		long before = System.nanoTime();
		FromTopToBottomMergeSort(array, 0, array.length - 1);
		long after = System.nanoTime();
		System.out.println("排序后的数组是：" + Arrays.toString(array));
		System.out.println("自顶向下排序过程耗时：" + (after - before) + "纳秒");

		array = new int[] { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5,
				4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };

		System.out.println("排序前的数组是：" + Arrays.toString(array));
		before = System.nanoTime();
		FromBottomToTopMergeSort(array, array.length);
		after = System.nanoTime();
		System.out.println("排序后的数组是：" + Arrays.toString(array));
		System.out.println("自底向上排序过程耗时：" + (after - before) + "纳秒");

	}

}
