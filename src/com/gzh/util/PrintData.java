package com.gzh.util;
/**
 * 打印数据工具类
 * @author gzh-t184
 *
 */
public class PrintData {
	/**
	 * 打印数组
	 * @param a
	 */
	public void printArray(int[] a) {
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j] + " ");
		}
		System.out.println();
	}
}
