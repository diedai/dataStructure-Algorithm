package com.gzh.order;

import com.gzh.util.PrintData;
import com.gzh.util.SwapData;

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
		System.out.println("---before sort---");
		PrintData printData = new PrintData();
		printData.printArray(a);

		//sort
		System.out.println("---sort data---");
		SwapData swapData = new SwapData();
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) { //j pointer scan
				// compare data
				if (a[j] < a[i]) { 
					// swap data
					swapData.swapData(a, i, j);
				}
			}
			
			// print data after sort
			printData.printArray(a); //the smallest value to the left
		}

		// print data after sort
		System.out.println("---after sort---");
		printData.printArray(a);

	}
}
