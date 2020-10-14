package counterStriker1_6;

import java.io.*;
import java.util.Scanner;

public class ReadLineTest {
	private File file;
	private File fileWritten;
	private BufferedWriter out;
	private int num = 3;// 要修改的行

	public ReadLineTest() {
		file = new File("C:/Users/Administrator/Desktop/ip.txt");// 指定源文件路径
		fileWritten = new File("F:/text.txt");// 指定写入文件路径
		try {
			out = new BufferedWriter(new FileWriter(fileWritten));
			cut(file, num);
			out.close();
			System.out.print("操作完成！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void cut(File file, int n) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			Scanner s = new Scanner(in);
			while (s.hasNextLine()) {
				out.write(s.nextLine() + "\r\n");
			}
			s.close();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ReadLineTest();
	}
}
