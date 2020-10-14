package fileName;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		String filePath = "D:/data1/itc/jetty/ftpfiles/";
		File file = new File(filePath);
		if (file == null || !file.isFile()) {
			throw new RuntimeException("文件不存在");
		}
	}

}
