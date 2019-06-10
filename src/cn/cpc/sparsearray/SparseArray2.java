package cn.cpc.sparsearray;

import java.io.*;

public class SparseArray2 {

	public static void main(String[] args) {

		//创建一个原始的二维数组11*11
		//0:没有旗子,1黑子,3蓝子
		int chessArray1[][]=new int[11][11];
		chessArray1[1][2]=1;
		chessArray1[2][3]=2;
		//输出原始二维数组
		System.out.println("原始二维数组:");
		for (int[] row : chessArray1) {
			for (int data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}

		//计算非0数据的个数
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if(chessArray1[i][j]!=0) {
					sum++;
				}
			}
		}
		System.out.println("非0数据个数:"+sum);
		//创建稀疏数组
		int sparseArray[][]=new int[sum+1][3];
		//初始化第一行数据
		sparseArray[0][0]=11;
		sparseArray[0][1]=11;
		sparseArray[0][2]=sum;

		//将二维数组中的数据存入稀疏数组中
		int count = 0;//用于记录第几个非0数据
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
		//二维数组转稀疏数组
		System.out.println("二维数组转稀疏数组:");
		for (int i = 0; i < sparseArray.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
		}
		//存盘
		BufferedWriter bos  =null;
		try {
			bos = new BufferedWriter((new FileWriter("1.txt")));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("写入失败");
		}
		for (int i = 0; i < sparseArray.length; i++) {
			try {
				bos.write(sparseArray[i][0]+","+sparseArray[i][1]+","+
						sparseArray[i][2]);
				bos.newLine();
				bos.flush();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("写入失败");
			}
		}
        try {
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
