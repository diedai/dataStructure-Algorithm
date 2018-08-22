package com.gzh.order;

import com.gzh.util.PrintData;
import com.gzh.util.SwapData;


/**
 * 
 * <pre>
 * 
 * ---总结---
 * 1.算法的目的
 * 本质上，都是为了减少比较次数和交换次数
 * 2.算法的思想
 * 本质上，就是想一种方法来解决1的问题，能解决1的问题就是好的算法思想
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
	 * 
	 * <pre>
	 * select sort
	 * 
	 * ---步骤---
	 * 和冒泡一样
	 * 1.比较数据
	 * 2.交换数据
	 * 
	 * ---区别---
	 * 1.冒泡
	 * 每趟每次都要交换数据。
	 * 2.选择
	 * 每趟只交换一次数据。实际上，这里是选择比冒泡快的唯一原因，也是算法之所以被优化的唯一原因。
	 * 
	 * 这是唯一的区别。其他都一样。
	 * 
	 * @author gzh
	 * @date 2018年8月22日 上午8:22:14
	 * @param a
	 * </pre>
	 */
	public static void selectOrder(int[] a) {
		SwapData swapData = new SwapData();
		
		for (int i = 0; i < a.length; i++) { 
			int temp = i; 
			for (int j = i+1; j < a.length; j++) {
				//1.compare data
				if (a[j]<a[i]) { //pointer j scan data, until find the small value //每一趟比较数据的过程当中，并没有交换数据，所以速度快就快在这里。即每一趟只需要交换1次数据，就是最小值和i交换。比较数据的次数还是和冒泡一样的，每一趟是N次。 //其他的和冒泡完全一样。
					temp = j; //这里没有交换数据，而是赋值。交换数据要等到每一趟结束之后( find the smallest value)，再交换。
				}
			}
			//2.swap data
			swapData.swapData(a,i,temp); //最小值和i交换
			
			printData.printArray(a);
		}
	}
	
	
}
