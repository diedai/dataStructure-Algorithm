/**
 * ѡ������
 * 1.ð������
 * ÿһ�ˣ������ķŵ����ұߡ�
 * ÿһ�ˣ��Ƚ�N�Σ�����N�Ρ�
 * 2.ѡ������
 * ÿһ�ˣ�����С�ķŵ�����ߡ�
 * ÿһ�ˣ��Ƚ�N�Σ�ֻ����һ�Ρ�����С�ĺ�����ߵĽ������ٶȵ�����Ҳ���ڽ��������������Ķ�һ����
 * @author gzh
 *
 */
public class SelectOrder {

	public static void main(String[] args) {
		//��һ������
		int[] i = {10,9,8,7,6,5,4,3,2,1};
		
		//����֮ǰ
		for (int j = 0; j < i.length; j++) {
			System.out.print(i[j] + " ");
		}
		System.out.println();
		
		//����
		selectOrder(i); //���򷽷�ֻ��Ҫ���򣬲���Ҫ�������ݣ���Ϊ�������������ã����Ե����򷽷����֮�������ֵ�Ѿ�������
		
		//����֮��
		for (int j = 0; j < i.length; j++) {
			System.out.print(i[j] + " ");
		}
	}
	
	/**
	 * ѡ������
	 * @param i ����������
	 */
	public static void selectOrder(int[] i) {
		for (int j = 0; j < i.length; j++) { //ÿһ��
			int temp = j; //����һ����ʱֵ�����ڱ�����Сֵ
			for (int j2 = j+1; j2 < i.length; j2++) {
				if (i[j2]<i[j]) {
					temp = j2;
				}
			}
			switchData(i,j,temp); //ÿһ�˱Ƚ����֮�󣬰���Сֵ�ŵ������
			
			//
			for (int j1 = 0; j1 < i.length; j1++) { //ÿһ�����֮�󣬴�ӡֵ
				System.out.print(i[j1] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * ��������
	 * @param i ����
	 * @param j 
	 * @param j2
	 */
	public static void switchData(int[] i,int j, int j2) {
		int temp = 0;
		temp = i[j]; //����
		i[j]=i[j2]; //����
		i[j2]=temp;
	}

}
