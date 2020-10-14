package path.test.p01;

import java.io.FileReader;

public class PathTest {

	public static void main(String[] args) throws Exception {
		
		System.out.println(PathTest.class.getResource("helloInP01.txt"));
		System.out.println(PathTest.class.getResource("/path/test/p01/helloInP01.txt"));
		
		FileReader fr = new FileReader(PathTest.class.getResource("/path/test/p02/helloInP02.txt").getFile());
		char[] buf = new char[1024];
		fr.read(buf);
		System.out.println(buf);
		fr.close();
	}

}
