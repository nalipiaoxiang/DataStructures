package cn.cpc.sparsearray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SparseArray3 {

	public static void main(String[] args) {
		List<int[]> data = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("1.txt"));
			String line=null;

			while ((line = br.readLine())!=null){
				//读取数据并赋值到稀疏数组
				String[] split = line.split(",");
				int[] array = {Integer.parseInt(split[0]),
						Integer.parseInt(split[1]),Integer.parseInt(split[2])};
				data.add(array);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("读取失败");
		}
		//读盘
		//创建稀疏数组
		int chessArray2[][] = new int[data.get(0)[0]][data.get(0)[1]];


		for (int i = 1; i <data.size() ; i++) {
			chessArray2[data.get(i)[0]][data.get(i)[1]]=
					data.get(i)[2];
		}
		//展示
		//二维数组
		for (int[] row : chessArray2) {
			for (int da : row) {
				System.out.printf("%d\t",da);
			}
			System.out.println();
		}


	}

}
