package com.gzh.order;

import com.gzh.util.PrintData;

/**
 * <pre>
 * 【插入排序】
 * 1.局部有序。左边局部有序，因为局部有序的右边的数据可能比局部有序里的数据要小，如果要小那么局部有序数据里的大的数据全部右移，并且将要小的数据插入合适位置。
 * 冒泡排序，左边有序，且索引位置不会变，因为左边有序就是最小的。 选择排序，右边有序，且索引位置不会变，因为右边有序就是最大的。
 * 
 * 【每一趟】
 * 1.每一趟，局部有序 
 * 2.第一趟，最左边的第一个数据是有序的；所以第一趟不用比较，是从第二趟开始比较的，第二趟的标志数据是第二个数据。
 * 
 * 【速度】
 * 每一趟比较数据的时候，有一个条件，就是找到合适位置之后，就不再比较了，比较次数少了一半。所以速度是冒泡的2倍，就是第二个for循环的N/2。
 * 比较次数也比选择排序也是少了一半，但是交换次数明显比选择排序多了很多，冒泡排序的交换次数是每一趟N，选择的交换次数是每一趟1，插入排序是N/2。所以，插入排序只比选择排序快一点。
 * 
 * 【应用场景】
 * 1.局部有序的数据
 * 局部有序，比较的次数在N/2的基础之上，再次大大减少。
 * 2.数据量较小
 * 本章的3个排序算法，速度都是N~2，都只适用于数据量较小的情况。
 * 数据量大，就用快速排序。
 * 在快速排序算法的步骤里，最后一步，使用了插入排序。
 * &#64;author gzh-t184
 * </pre>
 */
public class InsertOrder {

	public static void main(String[] args) {
		int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		// before sort
		System.out.println("---before sort---");
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j] + " ");
		}
		System.out.println();

		// sort
		System.out.println("---sort---");
		insertOrder(a); // 排序方法只需要排序，不需要返回数据，因为传参数组是引用，所以当排序方法完成之后数组的值已经被排序。

		// after sort
		System.out.println("---after sort---");
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j] + " ");
		}
	}

	
	/**
	 * 
	 * <pre>
	 * insert sort
	 * 
	 * ---步骤---
	 * 1.比较数据
	 * 2.交换数据
	 * 3.每一趟，指针去扫码数据
	 * 
	 * 步骤和冒泡排序差不多，可以说是完全一样。
	 * 
	 * ---区别---
	 * 一、插入
	 * 
	 * 二、冒泡
	 * 
	 * 
	 * @author gzh
	 * @date 2018年8月21日 上午9:59:36
	 * @param a
	 * </pre>
	 */
	public static void insertOrder(int[] a) {
		PrintData printData = new PrintData();

		for (int out = 1; out < a.length; out++) {
			int in = out;
			int temp = a[out]; // 标志数据
			while (in > 0 && a[in - 1] > temp) { // 把局部有序数据和标志数据进行比较，右移大的数据
				a[in] = a[in - 1];
				in--;
			}
			a[in] = temp; // 右移完成之后，插入标志数据到合适位置。注：这里没有明显的交换数据，但实际上，也隐式的包含了交换数据。

			printData.printArray(a);
		}
	}
}
