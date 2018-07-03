/**
 * 二分查找 思想 1.找到匹配值 2.比匹配值小 3.比匹配值大
 * 
 * 注意事项 1.有序数组 2.递归调用 3.small比large小
 * 
 * 需要继续完善的地方 1.如何返回匹配值的索引？
 * 这涉及到与API的通信(即读写想要的数据)。//代码参考维基百科的demo。思想参考数据结构和算法。
 * 
 * 
 * 2.如何打印没找到匹配值的情况？ 1.指针在范围以内 找到匹配值。 2.指针在范围以外 这种情况，就是没找到匹配值的情况。
 * 
 * 参考 数据结构和算法
 * 
 * 速度 1.顺序查找 N 2.二分查找 logN
 * 
 * 应用场景 1.经常查询数据，但是比较少增、删数据 2.如果增、删数据比较多，那么请使用顺序查找算法
 * 
 * 实现方法
 * 1.递归
 * 本例子是使用递归。
 * 2.非递归，使用循环
 * 参考数据结构和算法。
 * 
 * @author gzh
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] i = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int value = 8;
		int small = 0;
		int large = i.length - 1;
		int r = binarySearch(i, value, small, large);
		if (r != -1) {
			System.out.println("找到匹配值:" + "r=" + r + ",i[r]=" + i[r]);
		} 
	}

	/**
	 * 二分查找
	 * 
	 * @param i
	 *            数组
	 * @param value
	 *            要查找的值
	 * @param small
	 *            最小索引
	 * @param large
	 *            最大索引
	 * @return
	 */
	public static int binarySearch(int[] i, int value, int small, int large) {
		// 3个指针，分别指向最小索引/最大索引/中间索引
		int middle = (small + large) / 2;
		int middleValue = i[middle];

		// 指针在范围以外，找不到
		if (small > large) {
			System.out.println("small=" + small + ";large=" + large);
			System.out.println("没找到匹配值！！！");
			return -1; //给一个找不到的返回标志
		}

		// 指针在范围以内，找到匹配值
		if (middleValue < value) { // 比匹配值小
			small = middle + 1;
			return binarySearch(i, value, small, large);
		}

		if (middleValue > value) { // 比匹配值大
			large = middle - 1;
			return binarySearch(i, value, small, large);
		}

		System.out.println("找到匹配值:" + "middle=" + middle + ",middleValue=" + middleValue);
		return middle; //找到匹配值
	}

}
