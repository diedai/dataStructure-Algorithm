package com.gzh.order;

import com.gzh.util.PrintData;
import com.gzh.util.SwapData;

/**
 * 
 * <pre>
 * bubble sort
 * 
 * ---步骤---
 * 1.compare data
 * 2.swap data
 * 
 * --- scan data---
 * 3.pointer j scan, 10 times
 * every time, the smallest value to the left. and,the left data already have been sorted.
 * 
 * 
 * --- print data---
 * ---before sort---
10 9 8 7 6 5 4 3 2 1 
---sort---
1 10 9 8 7 6 5 4 3 2 
1 2 10 9 8 7 6 5 4 3 
1 2 3 10 9 8 7 6 5 4 
1 2 3 4 10 9 8 7 6 5 
1 2 3 4 5 10 9 8 7 6 
1 2 3 4 5 6 10 9 8 7 
1 2 3 4 5 6 7 10 9 8 
1 2 3 4 5 6 7 8 10 9 
1 2 3 4 5 6 7 8 9 10 
1 2 3 4 5 6 7 8 9 10 
---after sort---
1 2 3 4 5 6 7 8 9 10 

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
			for (int j = i + 1; j < a.length; j++) { //3.j pointer scan
				// 1.compare data
				if (a[j] < a[i]) { 
					// 2.swap data
					swapData.swapData(a, i, j); //每一趟，1.通过比较数据(N次，每趟每次都要比较)，找到最小值 2.交换数据(N/2 次,比较结果true/false各占一半，只有为true时才交换数据，所以交换次数只占比较次数的一半)：最小值和i
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
