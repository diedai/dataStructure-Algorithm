package com.gzh.order;
/**
 * 插入排序
 * 1.局部有序。左边局部有序，因为局部有序的右边的数据可能比局部有序里的数据要小，如果要小那么局部有序数据里的大的数据全部右移，并且将要小的数据插入合适位置。
 * 冒泡排序，左边有序，且索引位置不会变，因为左边有序就是最小的。 选择排序，右边有序，且索引位置不会变，因为右边有序就是最大的。
 * 
 * --- 1.每一趟，局部有序 2.第一趟，最左边的第一个数据是有序的；所以第一趟不用比较，是从第二趟开始比较的，第二趟的标志数据是第二个数据。
 * 
 * @author gzh-t184
 *
 */
public class InsertOrder {

	public static void main(String[] args) {
		// 有一个数组
		int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		// 排序之前
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j] + " ");
		}
		System.out.println();

		// 排序
		insertOrder(a); // 排序方法只需要排序，不需要返回数据，因为传参数组是引用，所以当排序方法完成之后数组的值已经被排序。

		// 排序之后
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j] + " ");
		}
	}

	/**
	 * 插入排序
	 * 
	 * @param a
	 */
	public static void insertOrder(int[] a) {
		for (int out = 1; out < a.length; out++) {
			int in = out;
			int temp = a[out]; // 标志数据
			while (in>0 && a[in - 1] > temp) { // 把局部有序数据和标志数据进行比较，右移大的数据
				a[in] = a[in - 1];
				in--;
			}

			a[in] = temp; // 右移完成之后，插入标志数据到合适位置。注：这里没有明显的交换数据，但实际上，也隐式的包含了交换数据。
		}
	}
}
