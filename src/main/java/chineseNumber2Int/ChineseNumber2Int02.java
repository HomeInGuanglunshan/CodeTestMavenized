package chineseNumber2Int;

import java.io.File;

/*
 * ��ĳ���ļ����е������ļ���copy��������������Щ�ļ����½��ļ�
 */
public class ChineseNumber2Int02 {

	public static void main(String[] args) {
		String path = "E:/1.��Դ����/1.��ʱ����/��ʱ����4 - ���ﳤ��/";
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
