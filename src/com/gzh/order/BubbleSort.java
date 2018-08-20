package com.gzh.order;

import com.gzh.util.PrintData;

/**
 * 
 * <pre>
 * bubble sort
 * &#64;author gongzhihao
 * &#64;date 2018年8月20日 下午11:07:43
 * </pre>
 */
public class BubbleSort {
	static int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

	public static void main(String[] args) {
		// print data before sort
		PrintData printData = new PrintData();
		printData.printArray(a);

		//sort
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				// compare data
				if (a[j] < a[i]) {
					// swap data
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}

		// print data after sort
		printData.printArray(a);

	}
}
