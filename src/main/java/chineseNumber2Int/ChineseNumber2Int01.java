package chineseNumber2Int;

import java.io.File;

/*
 * ��ĳ���ļ������к������ֵ��ļ����еĺ������֣��ĳɰ���������
 */
public class ChineseNumber2Int01 {

	public static void main(String[] args) {
		String path = "E:/1.��Դ����/1.��ʱ����/��ʱ����4 - ���ﳤ��/";
		// String path = "C:/Users/Administrator/Desktop/temp/";
		File file = new File(path);
		File[] tempList = file.listFiles();
		// System.out.println("��Ŀ¼�¶��������" + tempList.length);
		for (int i = 0; i < tempList.length; i++) {
			String oldName = tempList[i].getName();
			String newName = new ChineseNumber2Int01().convertName(oldName);
			tempList[i].renameTo(new File(path + newName));
		}
	}

	public String convertName(String oldName) {
		String cnNumber = oldName.substring(oldName.indexOf("��") + 1, oldName.indexOf("��"));
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
