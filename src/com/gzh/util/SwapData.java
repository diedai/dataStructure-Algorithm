package com.gzh.util;
/**
 * <pre>
 * 交换数据工具类
 * 
 * 如何使用？
 * SwapData swapData = new SwapData();
 * swapData.swapData(a, i, j);
 * @author gzh-t184
 * </pre>
 *
 */
public class SwapData {
	/**
	 * 交换数组的数据
	 * @param a 数组
	 * @param i 
	 * @param j
	 */
	public void swapData(int[] a,int i, int j) {
		int temp = 0;
		temp = a[i]; //保存
		a[i]=a[j]; //交换
		a[j]=temp;
	}
}
