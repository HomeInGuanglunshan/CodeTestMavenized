package console.input.keypress.test.p01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {

	public static void main(String[] args) throws IOException {
		String inputStr;
		// 使用 System.in 创建 BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (;;) {
			inputStr = br.readLine();
//			System.out.println(inputStr);
			if (inputStr.matches("[\\-\\+\\?]+")) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
