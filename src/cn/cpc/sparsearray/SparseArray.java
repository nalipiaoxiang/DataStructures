package cn.cpc.sparsearray;

public class SparseArray {

	public static void main(String[] args) {

		//����һ��ԭʼ�Ķ�ά����11*11
		//0:û������,1����,3����
		int chessArray1[][]=new int[11][11];
		chessArray1[1][2]=1;
		chessArray1[2][3]=2;
		//���ԭʼ��ά����
		for (int[] row : chessArray1) {
			
			for (int data : row) {
				System.out.printf("%d\t",data);
			}
			
			System.out.println();
		}
		
		int sum = 0;
		//�����0���ݵĸ���
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if(chessArray1[i][j]!=0) {
					sum++;
				}
			}
		}
		System.out.println("sum:"+sum);
		//����ϡ������
		int sparseArray[][]=new int[sum+1][3];
		sparseArray[0][0]=11;
		sparseArray[0][1]=11;
		sparseArray[0][2]=sum;
		
		//����ά�����е����ݴ���ϡ��������
		int count = 0;//���ڼ�¼�ڼ�����0����
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if(chessArray1[i][j]!=0) {
					count++;
					sparseArray[count][0]=i;
					sparseArray[count][1]=j;
					sparseArray[count][2]=chessArray1[i][j];
				}
			}
		}
		
		System.out.println("ϡ������");
		for (int i = 0; i < sparseArray.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
			
		}
		
		
		
	}

}
