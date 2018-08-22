package com.gzh.order;

import com.gzh.util.PrintData;

/**
 * <pre>
 * 改进版本
 * &#64;author gzh-t184
 * </pre>
 */
public class InsertOrder2 {
	static PrintData printData = new PrintData();

	public static void main(String[] args) {
		int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		// before sort
		System.out.println("---before sort---");
		printData.printArray(a);

		// sort
		System.out.println("---sort---");
		insertOrder(a); 

		// after sort
		System.out.println("---after sort---");
		printData.printArray(a);
	}

	
	/**
	 * 
	 * <pre>
	 * insert sort
	 * 
	 * --- 速度---
	 * 1.选择排序
	 * 
	 * 2.插入排序
	 * 快在什么地方呢？
	 * 1）比较数据
	 * 每一趟比较数据的时候，因为已经处理的局部数据是有序的，而插入排序每一趟都是选择一个基准值i和局部数据进行比较，所以这部分局部数据和基准值进行比较的时候，只要条件不满足，当前这一趟的数据比较就结束了，而不会接着比较局部数据里的下一个数据。所以理论上每一趟的速度是选择排序和冒泡排序的1/2，即N/2次比较。
	 * 2）交换数据
	 * 每一趟只交换一次，这一点和选择排序一样。但是就这一次交换的速度的话，插入排序是选择排序的1/3。
	 * 3）外层循环
	 * 只执行9次，少执行1次。
	 * 
	 * @author gzh
	 * @date 2018年8月21日 上午9:59:36
	 * @param a
	 * </pre>
	 */
	public static void insertOrder(int[] a) {
		int i,j;
		for ( i= 1; i < a.length; i++) {
			int temp = a[i]; 
			
			//1.compare data
			for (j = i; j > 0 && a[j - 1] > temp; j--) { //
				a[j] = a[j - 1]; //这里没有交换数据，只是赋值。和选择排序一样。那和选择排序的区别呢？1.选择排序是每一趟比较数据找到最小值，然后把最小值和i交换；2.插入排序是每一趟右移部分局部有序数据，最后把基准值(temp)和插入值(每一趟结束之后的索引位置)进行交换。
			}
			
			//2.swap data
			a[j] = temp; //每一趟结束之后，才交换数据。而且这里的交换数据是隐含的交换数据，即只有一次赋值，实际上真正的交换数据是3次赋值，所以单纯这一步的速度是选择排序的1/3。

			printData.printArray(a);
		}
	}
}
