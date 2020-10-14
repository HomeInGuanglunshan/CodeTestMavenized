package fileDeletingTest;

import java.io.File;

public class FileDeletingTest {

	public static void main(String[] args) {
		for (int i = 1; i <= 3; i++) {
			File file = new File("C:/Users/Administrator/Desktop/新建文件夹" + "/" + i + ".txt");
			file.delete();
		}
	}

}
