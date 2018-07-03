/**
 * 选择排序
 * 1.冒泡排序
 * 每一趟，把最大的放到最右边。
 * 每一趟，比较N次，交换N次。
 * 2.选择排序
 * 每一趟，把最小的放到最左边。
 * 每一趟，比较N次，只交换一次。把最小的和最左边的交换。速度的区别也在于交换次数，其他的都一样。
 * @author gzh
 *
 */
public class SelectOrder {

	public static void main(String[] args) {
		//有一个数组
		int[] i = {10,9,8,7,6,5,4,3,2,1};
		
		//排序之前
		for (int j = 0; j < i.length; j++) {
			System.out.print(i[j] + " ");
		}
		System.out.println();
		
		//排序
		selectOrder(i); //排序方法只需要排序，不需要返回数据，因为传参数组是引用，所以当排序方法完成之后数组的值已经被排序。
		
		//排序之后
		for (int j = 0; j < i.length; j++) {
			System.out.print(i[j] + " ");
		}
	}
	
	/**
	 * 选择排序
	 * @param i 待排序数组
	 */
	public static void selectOrder(int[] i) {
		for (int j = 0; j < i.length; j++) { //每一趟
			int temp = j; //都有一个临时值，用于保存最小值
			for (int j2 = j+1; j2 < i.length; j2++) {
				if (i[j2]<i[j]) {
					temp = j2;
				}
			}
			switchData(i,j,temp); //每一趟比较完毕之后，把最小值放到最左边
			
			//
			for (int j1 = 0; j1 < i.length; j1++) { //每一趟完毕之后，打印值
				System.out.print(i[j1] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 交换数据
	 * @param i 数组
	 * @param j 
	 * @param j2
	 */
	public static void switchData(int[] i,int j, int j2) {
		int temp = 0;
		temp = i[j]; //保存
		i[j]=i[j2]; //交换
		i[j2]=temp;
	}

}
