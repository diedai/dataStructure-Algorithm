package com.gzh.search;
/**
 * ���ֲ��� ˼�� 1.�ҵ�ƥ��ֵ 2.��ƥ��ֵС 3.��ƥ��ֵ��
 * 
 * ע������ 1.�������� 2.�ݹ���� 3.small��largeС
 * 
 * ��Ҫ�������Ƶĵط� 1.��η���ƥ��ֵ��������
 * ���漰����API��ͨ��(����д��Ҫ������)��//����ο�ά���ٿƵ�demo��˼��ο����ݽṹ���㷨��
 * 
 * 
 * 2.��δ�ӡû�ҵ�ƥ��ֵ������� 1.ָ���ڷ�Χ���� �ҵ�ƥ��ֵ�� 2.ָ���ڷ�Χ���� �������������û�ҵ�ƥ��ֵ�������
 * 
 * �ο� ���ݽṹ���㷨
 * 
 * �ٶ� 1.˳����� N 2.���ֲ��� logN
 * 
 * Ӧ�ó��� 1.������ѯ���ݣ����ǱȽ�������ɾ���� 2.�������ɾ���ݱȽ϶࣬��ô��ʹ��˳������㷨
 * 
 * ʵ�ַ���
 * 1.�ݹ�
 * ��������ʹ�õݹ顣
 * 2.�ǵݹ飬ʹ��ѭ��
 * �ο����ݽṹ���㷨��
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
			System.out.println("�ҵ�ƥ��ֵ:" + "r=" + r + ",i[r]=" + i[r]);
		} 
	}

	/**
	 * ���ֲ���
	 * 
	 * @param i
	 *            ����
	 * @param value
	 *            Ҫ���ҵ�ֵ
	 * @param small
	 *            ��С����
	 * @param large
	 *            �������
	 * @return
	 */
	public static int binarySearch(int[] i, int value, int small, int large) {
		// 3��ָ�룬�ֱ�ָ����С����/�������/�м�����
		int middle = (small + large) / 2;
		int middleValue = i[middle];

		// ָ���ڷ�Χ���⣬�Ҳ���
		if (small > large) {
			System.out.println("small=" + small + ";large=" + large);
			System.out.println("û�ҵ�ƥ��ֵ������");
			return -1; //��һ���Ҳ����ķ��ر�־
		}

		// ָ���ڷ�Χ���ڣ��ҵ�ƥ��ֵ
		if (middleValue < value) { // ��ƥ��ֵС
			small = middle + 1;
			return binarySearch(i, value, small, large);
		}

		if (middleValue > value) { // ��ƥ��ֵ��
			large = middle - 1;
			return binarySearch(i, value, small, large);
		}

		System.out.println("�ҵ�ƥ��ֵ:" + "middle=" + middle + ",middleValue=" + middleValue);
		return middle; //�ҵ�ƥ��ֵ
	}

}
