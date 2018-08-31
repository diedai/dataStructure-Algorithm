package com.gzh.order;

import com.gzh.util.PrintData;

/**
 * 归并排序
 * <pre>
 * @author gzh
 *
 * </pre>
 */
public class MergeOrder {
	static int[] a= {8,7,6,5,4,3,2,1};

	public static void main(String[] args) {
		
		
		int[] temp = new int[8];
		for (int i = 0; i < a.length; i++) {
			temp[i]= a[i];
			
		}
		
		recMergeOrder(temp, 0, temp.length-1); //最小和最大值，和数组的索引值保持一致，这样便于理解
	}
	
	/**
	 * 递归调用归并排序
	 * <pre>
	 * @author gzh
	 * @date 2018年8月31日 下午6:24:44
	 * @param temp 临时数组
	 * @param small 最小值索引
	 * @param large 最大值索引
	 * </pre>
	 */
	private static void recMergeOrder(int[] temp,int small, int large) {
		int middle = (small+large) / 2; //中间值因为可以通过最小和最大计算，所以不应该放在方法参数里。
		System.out.println("small=" + small + ",middle=" + middle + ",large=" + large);
		
		if (small==large) { //剩下一个数据的标志是什么？就是最小和最大值相等
			return; //剩下一个数据结束递归调用
		} else { //否则
			//递归调用左边
			recMergeOrder(temp, small, middle);
			System.out.println("左递归完成");
			//递归调用右边
			recMergeOrder(temp, middle+1, large);
			System.out.println("右递归完成");
			
			//归并排序
			mergeOrder(temp, small, large);
			
			PrintData printData = new PrintData();
			printData.printArray(a);
			System.out.println("---归并排序完成---");
		}	
	}

	/**
	 * 归并排序
	 * <pre>
	 * @author gzh
	 * @date 2018年8月31日 下午6:23:50
	 * @param temp 临时数组
	 * @param small 最小值索引
	 * @param large 最大值索引
	 * </pre>
	 */
	private static void mergeOrder(int[] temp,int small,int large) {
		int middle = (small+large) / 2 + 1; //中间值因为可以通过最小和最大计算，所以不应该放在方法参数里。
		System.out.println("---归并排序: small=" + small + ",middle=" + middle + ",large=" + large + "---");
		
		int t=0; //temp数组的索引 //作用：每一趟里(每一趟归0)，每次找到一个最小的数据，就放到临时数组里。这个变量就起一个指针的作用。
		int small2=small; //2个数组，分别有个指针扫描数据。//small2扫码左边子数组 
//		int large2=large; //不需要
		int middle2 = (small+large) / 2 + 1; //middle2扫描右边子数组 
		

		//复制小的数据到临时数组
		while (small2<middle && middle2<=large) { //这里有2个变量，即2个指针在移动，所以循环结束的标志是2个表达式同时为真
			if (a[small2] < a[middle2]) { //复制A数组里小的数据
		        temp[t++]=a[small2++];
			} else { //否则，复制B数组里小的数据
				temp[t++]=a[middle2++];
			}
		}
		
		//复制剩下的A数组里的数据
		while (small2 < middle) { //2个数组，分别有个最大基准值。//middle是左边子数组的最大基准值 //条件表达式可以是：1.small2 < middle   2.small2 <= （middle-1）。因为middle是右边子数组的最小值。
			temp[t++]=a[small2++]; 
		}
		
		//复制剩下的B数组里的数据
		while (middle2 <= large) { //large是右边子数组的最大基准值
			temp[t++]=a[middle2++];
		}
		
		//把排序的数据复制到源数组
		for (int j2 = 0; j2 < t; j2++) {
			a[small+j2] = temp[j2];
		}
	}

}
