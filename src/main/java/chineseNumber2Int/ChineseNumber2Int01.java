package chineseNumber2Int;

import java.io.File;

/*
 * 将某个文件夹中有汉字数字的文件名中的汉字数字，改成阿拉伯数字
 */
public class ChineseNumber2Int01 {

	public static void main(String[] args) {
		String path = "E:/1.资源共享/1.秦时明月/秦时明月4 - 万里长城/";
		// String path = "C:/Users/Administrator/Desktop/temp/";
		File file = new File(path);
		File[] tempList = file.listFiles();
		// System.out.println("该目录下对象个数：" + tempList.length);
		for (int i = 0; i < tempList.length; i++) {
			String oldName = tempList[i].getName();
			String newName = new ChineseNumber2Int01().convertName(oldName);
			tempList[i].renameTo(new File(path + newName));
		}
	}

	public String convertName(String oldName) {
		String cnNumber = oldName.substring(oldName.indexOf("第") + 1, oldName.indexOf("集"));
		int arabicNumber = ChineseNumber2Int04.cnNumericToArabic(cnNumber, true);
		String finalNumber = "";
		if (arabicNumber < 10) {
			finalNumber = "0" + arabicNumber;
		} else {
			finalNumber = "" + arabicNumber;
		}
		String newName = oldName.replaceAll(cnNumber, finalNumber).replaceAll(" ", " - ");
		return newName;
	}

}
