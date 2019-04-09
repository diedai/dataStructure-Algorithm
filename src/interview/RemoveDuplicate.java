package interview;

/**
 * 数组去重 1.数组有序 2.原地去重
 * 
 * <pre>
 * 打印结果
 * 1 1 2 2 3 
1 2 2 2 3 
1 2 2 2 3 
1 2 3 2 3 
1 2 3 

---
思路
利用荷兰国旗的思路，每次记住最后一个位置，遇到一个不重复的数，放在它后面，代码很简单。

参考
https://www.bbsmax.com/A/gVdnEDgN5W/


 * &#64;author gongzhihao	
 * &#64;date 2019年4月9日 上午10:38:59
 * </pre>
 */
public class RemoveDuplicate {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 2, 3 };
		// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
		int len = removeDuplicates(nums);

		// 在函数里修改输入数组对于调用者是可见的。
		// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
		for (int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	private static int removeDuplicates(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return 0;
		int pos = 0;

		for (int i = 1; i < len; i++) {
			if (nums[i] != nums[pos]) {
				pos++;
				nums[pos] = nums[i];

			}

			for (int i2 = 0; i2 < len; i2++) {
				System.out.print(nums[i2] + " ");
			}
			System.out.println();
		}
		return pos + 1;
	}

}

