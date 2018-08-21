package com.gzh.order;

import com.gzh.util.PrintData;
import com.gzh.util.SwapData;


/**
 * 
 * <pre>
 * 
 * ---print data---
 * ---before sort---
10 9 8 7 6 5 4 3 2 1 
---sort---
1 9 8 7 6 5 4 3 2 10 
1 2 8 7 6 5 4 3 9 10 
1 2 3 7 6 5 4 8 9 10 
1 2 3 4 6 5 7 8 9 10 
1 2 3 4 5 6 7 8 9 10 
1 2 3 4 5 6 7 8 9 10 
1 2 3 4 5 6 7 8 9 10 
1 2 3 4 5 6 7 8 9 10 
1 2 3 4 5 6 7 8 9 10 
1 2 3 4 5 6 7 8 9 10 
---after sort---
1 2 3 4 5 6 7 8 9 10 

 * @author gongzhihao
 * @date 2018年8月21日 下午2:08:50
 * </pre>
 */
public class SelectOrder2 {
	static PrintData printData = new PrintData();

	public static void main(String[] args) {
		int[] a = {10,9,8,7,6,5,4,3,2,1};
		
		//before sort
		System.out.println("---before sort---");
		printData.printArray(a);
		
		//sort
		System.out.println("---sort---");
		selectOrder(a); 
		
		//after
		System.out.println("---after sort---");
		printData.printArray(a);
	}
	
	/**
	 * 选择排序
	 * @param a 待排序数组
	 */
	public static void selectOrder(int[] a) {
		SwapData swapData = new SwapData();
		
		for (int i = 0; i < a.length; i++) { 
			int temp = i; 
			for (int j = i+1; j < a.length; j++) {
				if (a[j]<a[i]) { //pointer j scan data, until find the small value //每一趟比较数据的过程当中，并没有交换数据，所以速度快就快在这里。即每一趟只需要交换1次数据，就是最小值和i交换。比较数据的次数还是和冒泡一样的，每一趟是N次。
					temp = j;
				}
			}
			swapData.swapData(a,i,temp); 
			
			printData.printArray(a);
		}
	}
	
	
}
