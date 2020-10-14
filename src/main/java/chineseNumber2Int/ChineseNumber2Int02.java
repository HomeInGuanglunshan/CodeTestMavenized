package chineseNumber2Int;

import java.io.File;

/*
 * 将某个文件夹中的所有文件名copy出来，再利用这些文件名新建文件
 */
public class ChineseNumber2Int02 {

	public static void main(String[] args) {
		String path = "E:/1.资源共享/1.秦时明月/秦时明月4 - 万里长城/";
		File file = new File(path);
		File[] tempList = file.listFiles();
		for (int i = 0; i < tempList.length; i++) {
			String fileName = tempList[i].getName().replaceAll("[.][^.]+$", "");
			File file2 = new File("C:/Users/Administrator/Desktop/temp/" + fileName + ".txt");
			try {
				file2.createNewFile();
			} catch (Exception e) {
				System.out.println("FAIL");
			}
		}
	}

}
