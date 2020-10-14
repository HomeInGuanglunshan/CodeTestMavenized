package fileName;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class Filepath {

	public static void main(String[] args) throws IOException {
		Vector<String> vecFile = GetTestXlsFileName("F:/");
		for (int i = 0; i < vecFile.size(); i++) {
			System.out.println(vecFile.get(i));
		}
	}

	public static Vector<String> GetTestXlsFileName(String fileAbsolutePath) {
		Vector<String> vecFile = new Vector<String>();
		File file = new File(fileAbsolutePath);
		File[] subFile = file.listFiles();

		for (int iFileLength = 0; iFileLength < subFile.length; iFileLength++) {
			// 判断是否为文件夹
//			if (!subFile[iFileLength].isDirectory()) {
				String fileName = subFile[iFileLength].getName();
				// 判断是否为.txt结尾
//				if (fileName.trim().toLowerCase().endsWith(".txt")) {
					vecFile.add(fileName);
//				}
//			}
		}
		return vecFile;
	}
}