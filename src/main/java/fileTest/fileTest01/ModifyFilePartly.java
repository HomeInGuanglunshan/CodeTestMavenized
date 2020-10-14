package fileTest.fileTest01;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ModifyFilePartly {

	private static String FILEPATH = "C:/Users/Administrator/Desktop/";

	private static boolean modifyFileContent(String fileName, String oldstr, String newStr) {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(FILEPATH + "/" + fileName, "rw");
			String line = null;
			long lastPoint = 0; // 记住上一次的偏移量
			while ((line = raf.readLine()) != null) {
				final long point = raf.getFilePointer();
				System.out.println(point);
				if (line.contains(oldstr)) {
					String str = line.replace(oldstr, newStr);
					raf.seek(lastPoint);
					raf.writeBytes(str);
				}
				lastPoint = point;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		modifyFileContent("temp.txt", "you", "me");
	}

}
