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
 * ---划分算法-速度---
 * N。 //因为2个指针在扫码数据，结束条件是2个指针相遇，所以是N。
 * 
 * ---快速排序-速度---
 * 1.二分法进行递归调用logN
 * 2.每次递归方法调用划分算法的方法N
 * 
 * 所以，快读排序算法速度是N * logN。
 * 
 * 
 * &#64;author gongzhihao
 * &#64;date 2018年9月28日 下午10:29:00
 * </pre>
 */
public class QuickSort {
	static PrintData printData = new PrintData();

	// 数据
	static int[] a = { 1, 9, 10, 8, 100, 60, 50, 4, 3, 20, 7 };

	public static void main(String[] args) {
		//partition(0, a.length-1);
		
		//排序
		System.out.println("before sort");
		printData.printArray(a);
		quickSort(0,a.length-1);

		// 排序之后
		printData.printArray(a);
	}

	/**
	 * 快速排序
	 * <pre>
	 * @author gzh
	 * @date 2018年10月4日 下午10:06:20
	 * @param left
	 * @param right
	 * </pre>
	 */
	private static void quickSort(int left, int right) {
		if(left >= right) { //结束标志
			return;
		}else { //递归调用
			//划分算法
			int pivot = partitionSort(left, right);
			//左递归调用
			quickSort(left, pivot-1);
			//右递归调用
			quickSort(pivot+1, right);
		}
	}
	
	

//	/**
//	 * 划分算法
//	 * <pre>
//	 * 思想
//	 * 1.二分法
//	 * 2.有个基准值，
//	 * 1）比基准值小的放左边 //左边子数组无序
//	 * 2）比基准值大的放右边 //右边子数组无序
//	 * @author gzh 
//	 * @date 2018年10月4日 下午10:06:28
//	 * @param left1
//	 * @param right1
//	 * </pre>
//	 * @return 
//	 */
//	private static int partition(int left, int right) { //参数
//		// 排序数据
//		int leftP = left - 1, rightP = right + 1; //扫描指针
//		int pivot = a[right]; //基准值
//		System.out.println("基准值索引是：" + right + "基准值是：" + pivot);
//		while (true) {
//			// 从最左边开始遍历数据，直到找到一个比基准值大的数据
//			while (leftP < right && a[++leftP] < pivot) {
//
//			}
//
//			// 从最右边开始遍历数据，直到找到一个比基准值小的数据
//			while (rightP > left && a[--rightP] > pivot) {
//
//			}
//
//			if (leftP >= rightP) { //结束条件是？2个指针相遇的时候。为什么呢？因为左指针已经到右边子数组，右边子数组全部比基准值大，所以左指针不需要再往右扫描移动；同样道理，右指针已经到了左边子数组，左边子数组全部比基准值小，所以右指针不需要再往左扫描移动。总而言之，现在两边子数组已经划分完毕，两个指针停止移动扫描，循环结束。 // 结束掉外层while的标志条件要放在内层while和交换数据的代码之间，因为内层while循环的指针会自增和自减，自增和自减到最后一个数据的时候，就是结束条件，这个时候要结束外层while循环，因为数据已经局部有序了，否则的话，还会交换一次数据，导致数据又乱序了(例如，假设把结束条件放在while循环的条件判断语句，就会多比较最后一次)。
//				break;
//			} else {
//				// 交换数据。交换大的数据和小的数据，把它们放到基准值的右边和左边
//				SwapData swapData = new SwapData();
//				swapData.swapData(a, leftP, rightP);
//
//				printData.printArray(a);
//			}
//		}
//		
//		return leftP;
//
//	}
	
	/**
	 * 划分算法（用于快速排序，改动了一点点地方）
	 * <pre>
	 * @author gzh
	 * @date 2018年10月5日 上午12:54:24
	 * @param left
	 * @param right
	 * @return ?
	 * </pre>
	 */
	private static int partitionSort(int left, int right) { //参数
		System.out.println("---本次划分开始---");
		System.out.println("划分范围的索引是：left=" + left + "~" + "right=" + right);
		SwapData swapData = new SwapData();
		
		// 排序数据
		int leftP = left - 1, rightP = right; //扫描指针 //以最右边数据为基准值进行划分，最右边数据不参与划分算法；但是在划分算法while循环完毕之后，需要交换数据(最右边数据索引和左边指针索引)，目的是把基准值放到左右子数组的中间。
		int pivot = a[right]; //基准值
		System.out.println("基准值是a[" + right + "]=" + a[right]);
		while (true) {
			// 从最左边开始遍历数据，直到找到一个比基准值大的数据
			while (leftP < right && a[++leftP] < pivot) {

			}

			// 从最右边开始遍历数据，直到找到一个比基准值小的数据
			while (rightP > left && a[--rightP] > pivot) {

			}

			if (leftP >= rightP) { //结束条件是？2个指针相遇的时候。为什么呢？因为左指针已经到右边子数组，右边子数组全部比基准值大，所以左指针不需要再往右扫描移动；同样道理，右指针已经到了左边子数组，左边子数组全部比基准值小，所以右指针不需要再往左扫描移动。总而言之，现在两边子数组已经划分完毕，两个指针停止移动扫描，循环结束。 // 结束掉外层while的标志条件要放在内层while和交换数据的代码之间，因为内层while循环的指针会自增和自减，自增和自减到最后一个数据的时候，就是结束条件，这个时候要结束外层while循环，因为数据已经局部有序了，否则的话，还会交换一次数据，导致数据又乱序了(例如，假设把结束条件放在while循环的条件判断语句，就会多比较最后一次)。
				break;
			} else {
				// 交换数据。交换大的数据和小的数据，把它们放到基准值的右边和左边
				System.out.println("左边比基准值大的数据是a[" + leftP + "]=" + a[leftP]);
				System.out.println("右边比基准值小的数据是a[" + rightP + "]=" + a[rightP]);
				swapData.swapData(a, leftP, rightP);

				printData.printArray(a);
			}
		}
		
		System.out.println("当前划分结束：leftP=" + leftP + ",rightP=" + rightP);
		System.out.println("最后一步，把左指针的值和基准值进行交换，实际上是把右边数据的第一个数据和基准值进行交换——最终，基准值的左边数据比基准值都小(但是是无序)，基准值右边的数据比基准值都大(但是是无序)");
		swapData.swapData(a,leftP,right);
		printData.printArray(a);
		System.out.println("---本次划分结束---");
		System.out.println();
		return leftP;

	}

	

}

//输出结果
/*

 before sort
1 9 10 8 100 60 50 4 3 20 7 
---本次划分开始---
划分范围的索引是：left=0~right=10
基准值是a[10]=7
左边比基准值大的数据是a[1]=9
右边比基准值小的数据是a[8]=3
1 3 10 8 100 60 50 4 9 20 7 
左边比基准值大的数据是a[2]=10
右边比基准值小的数据是a[7]=4
1 3 4 8 100 60 50 10 9 20 7 
当前划分结束：leftP=3,rightP=2
最后一步，把左指针的值和基准值进行交换，实际上是把右边数据的第一个数据和基准值进行交换——最终，基准值的左边数据比基准值都小(但是是无序)，基准值右边的数据比基准值都大(但是是无序)
1 3 4 7 100 60 50 10 9 20 8 
---本次划分结束---

---本次划分开始---
划分范围的索引是：left=0~right=2
基准值是a[2]=4
当前划分结束：leftP=2,rightP=1
最后一步，把左指针的值和基准值进行交换，实际上是把右边数据的第一个数据和基准值进行交换——最终，基准值的左边数据比基准值都小(但是是无序)，基准值右边的数据比基准值都大(但是是无序)
1 3 4 7 100 60 50 10 9 20 8 
---本次划分结束---

---本次划分开始---
划分范围的索引是：left=0~right=1
基准值是a[1]=3
当前划分结束：leftP=1,rightP=0
最后一步，把左指针的值和基准值进行交换，实际上是把右边数据的第一个数据和基准值进行交换——最终，基准值的左边数据比基准值都小(但是是无序)，基准值右边的数据比基准值都大(但是是无序)
1 3 4 7 100 60 50 10 9 20 8 
---本次划分结束---

---本次划分开始---
划分范围的索引是：left=4~right=10
基准值是a[10]=8
当前划分结束：leftP=4,rightP=4
最后一步，把左指针的值和基准值进行交换，实际上是把右边数据的第一个数据和基准值进行交换——最终，基准值的左边数据比基准值都小(但是是无序)，基准值右边的数据比基准值都大(但是是无序)
1 3 4 7 8 60 50 10 9 20 100 
---本次划分结束---

---本次划分开始---
划分范围的索引是：left=5~right=10
基准值是a[10]=100
当前划分结束：leftP=10,rightP=9
最后一步，把左指针的值和基准值进行交换，实际上是把右边数据的第一个数据和基准值进行交换——最终，基准值的左边数据比基准值都小(但是是无序)，基准值右边的数据比基准值都大(但是是无序)
1 3 4 7 8 60 50 10 9 20 100 
---本次划分结束---

---本次划分开始---
划分范围的索引是：left=5~right=9
基准值是a[9]=20
左边比基准值大的数据是a[5]=60
右边比基准值小的数据是a[8]=9
1 3 4 7 8 9 50 10 60 20 100 
左边比基准值大的数据是a[6]=50
右边比基准值小的数据是a[7]=10
1 3 4 7 8 9 10 50 60 20 100 
当前划分结束：leftP=7,rightP=6
最后一步，把左指针的值和基准值进行交换，实际上是把右边数据的第一个数据和基准值进行交换——最终，基准值的左边数据比基准值都小(但是是无序)，基准值右边的数据比基准值都大(但是是无序)
1 3 4 7 8 9 10 20 60 50 100 
---本次划分结束---

---本次划分开始---
划分范围的索引是：left=5~right=6
基准值是a[6]=10
当前划分结束：leftP=6,rightP=5
最后一步，把左指针的值和基准值进行交换，实际上是把右边数据的第一个数据和基准值进行交换——最终，基准值的左边数据比基准值都小(但是是无序)，基准值右边的数据比基准值都大(但是是无序)
1 3 4 7 8 9 10 20 60 50 100 
---本次划分结束---

---本次划分开始---
划分范围的索引是：left=8~right=9
基准值是a[9]=50
当前划分结束：leftP=8,rightP=8
最后一步，把左指针的值和基准值进行交换，实际上是把右边数据的第一个数据和基准值进行交换——最终，基准值的左边数据比基准值都小(但是是无序)，基准值右边的数据比基准值都大(但是是无序)
1 3 4 7 8 9 10 20 50 60 100 
---本次划分结束---

1 3 4 7 8 9 10 20 50 60 100 

 */
