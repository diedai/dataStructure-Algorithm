package com.gzh.order;

import com.gzh.util.PrintData;

/**
 * 希尔排序
 * <pre>
 * 思想
 * 1.使用间隔数列：1，4，7，10，13...。
 * 每一趟内循环，就是间隔数列的一个数字。
 * 
 * 2.使用插入排序
 * 每一趟内循环，就是一趟插入排序。
 * 
 * 插入排序。//插入排序的思想就是，1.右移所有大的数据 2.插入temp数据到合适位置
 * 
 * ---
 * 怎么实现？
 * 1.一个外循环
 * 使用for循环。因为是遍历。
 * 
 * 2.一个内循环
 * 使用while循环。因为是插入排序。
 * 
 * ---
 * 速度
 * 1.外层循环是N
 * 2.内存循环也是N //书上说是差不多logN。极客时间说是N(因为是while循环，和插入排序一样，所以速度应该也和插入排序一样，也是N；但是希尔排序度使用了间隔数列，所以比插入排序的N快了很多，但是又不是完完全全的二分logN，因为使用了while循环，所以其实速度应该是在logN到N之间；归并排序使用了二分，所以速度是logN，比希尔排序要快，但是归并排序需要2倍的数组空间，因为使用了临时数组，把临时数组排序之后，再复制数据到原始数组)。
 * 
 * 所以，速度是N*N。
 * 
 * 
 * 
 * 
 * @author gongzhihao
 * @date 2018年9月28日 上午2:27:34
 * </pre>
 */
public class ShellSort {

	public static void main(String[] args) {
		//数组
		int[] a= {10,9,8,7,6,5,4,3,2,1};
		
		PrintData printData = new PrintData();
		
		//排序
//		int h = 1;
//		h = h*3 + 1;
		int h=1;
		while(h <= a.length/3) {
			h = h*3 + 1; //希尔间隔：1,4,7,10,13...
		}
		
		while(h>0) { //最终结束
			for (int out = h; out < a.length; out++) { //每一趟结束 //每一趟，指h的值。即每个h的值就是一趟
				int in = out;
				int temp = a[out];
				while(in>h-1 && a[in-h]>temp) { //1.注意结束标志：是in>h-1。这是内循环in结束的标志。2.结束标志这个结束条件必须在&&的前面，否则数组越界异常。
					//交换数据
					a[in] = a[in-h]; //右移所有大的数据
					in-=h;
				}
				//交换数据
				a[in] = temp; //插入数据到合适位置(所有大的数据的前面)。使用了插入排序的思想，所以while循环和插入排序一样。
			}
			printData.printArray(a);
			
			h=(h-1)/3; //与上面的倒着来
		}
		
		//排序之后
		printData.printArray(a);
	}

}
