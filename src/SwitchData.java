/**
 * 交换数据工具类
 * 
 * 如何使用？
 * SwitchData switchData = new SwitchData();
 * switchData.switchData(a, i, j);
 * @author gzh-t184
 *
 */
public class SwitchData {
	/**
	 * 交换数组的数据
	 * @param a 数组
	 * @param i 
	 * @param j
	 */
	public void switchArray(int[] a,int i, int j) {
		int temp = 0;
		temp = a[i]; //保存
		a[i]=a[j]; //交换
		a[j]=temp;
	}
}
