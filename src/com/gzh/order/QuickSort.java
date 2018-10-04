package com.gzh.order;

import com.gzh.util.PrintData;
import com.gzh.util.SwapData;

/**
 * 快速排序
 * 
 * <pre>
 * 思想
 * 1.基于划分思想和划分算法
 * 2.快速排序
 * 
 * ---
 * 划分算法
 * #步骤
 * 1.选一个基准值
 * 
 * 2.每一趟
 * 1）分别从最左和最右扫描数据
 * 2）交换数据
 * 
 * 3.完成
 * 
 * #如何选择基准值？
 * 一般都是选择中间值。
 * 
 * 
 * &#64;author gongzhihao
 * &#64;date 2018年9月28日 下午10:29:00
 * </pre>
 */
public class QuickSort {
	static PrintData printData = new PrintData();

	// 数据
	static int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

	public static void main(String[] args) {
		// 划分算法
		partition(0, a.length);

		// 排序之后
		printData.printArray(a);
	}

	private static void partition(int left1, int right1) {
		// 排序数据
		int left = left1, right = right1;
		int leftP = left - 1, rightP = right;
		int pivot = 5;
		while (true) {
			// 从最左边开始遍历数据，直到找到一个比基准值大的数据
			while (leftP < right && a[++leftP] < pivot) {

			}

			// 从最右边开始遍历数据，直到找到一个比基准值小的数据
			while (rightP > left && a[--rightP] > pivot) {

			}

			if (leftP >= rightP) { // 结束掉外层while的标志条件要放在内层while和交换数据的代码之间，因为内层while循环的指针会自增和自减，自增和自减到最后一个数据的时候，就是结束条件，这个时候要结束外层while循环，因为数据已经局部有序了，否则的话，还会交换一次数据，导致数据又乱序了(例如，假设把结束条件放在while循环的条件判断语句，就会多比较最后一次)。
				break;
			} else {
				// 交换数据。交换大的数据和小的数据，把它们放到基准值的右边和左边
				SwapData swapData = new SwapData();
				swapData.swapData(a, leftP, rightP);

				printData.printArray(a);
			}
		}

	}

}
