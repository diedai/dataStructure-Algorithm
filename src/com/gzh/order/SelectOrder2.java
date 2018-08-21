package com.gzh.order;

import com.gzh.util.PrintData;
import com.gzh.util.SwapData;

/**
 * 选择排序
 * 1.冒泡排序
 * 每一趟，把最大的放到最右边。
 * 每一趟，比较N次，交换N次。
 * 2.选择排序
 * 每一趟，把最小的放到最左边。
 * 每一趟，比较N次，只交换一次。把最小的和最左边的交换。速度的区别也在于交换次数，其他的都一样，他们的速度都是N~2，因为有2个for循环，但是选择排序由于交换次数少一点所以快一点。
 * @author gzh
 *
 */
public class SelectOrder2 {
	static PrintData printData = new PrintData();

	public static void main(String[] args) {
		//有一个数组
		int[] a = {10,9,8,7,6,5,4,3,2,1};
		
		//before sort
		System.out.println("---before sort---");
		printData.printArray(a);
		
		//sort
		System.out.println("---sort---");
		selectOrder(a); //排序方法只需要排序，不需要返回数据，因为传参数组是引用，所以当排序方法完成之后数组的值已经被排序。
		
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
			swapData.swapData(a,i,temp); //每一趟比较完毕之后，把最小值放到最左边
			
			printData.printArray(a);
		}
	}
	
	
}
