package fileName;

import java.io.File;

public class FileNameTest {

	public static void main(String[] args) {

		String fName = "/home/ampmon/jetty/ftpfiles/arp_20160701101806";

		File tempFile = new File(fName.trim());

		String fileName = tempFile.getName();
		
		String path = tempFile.getParentFile().getName();

		System.out.println("fileName = " + fileName);
		
		System.out.println(fName.substring(0, fName.lastIndexOf("/")));
		
		System.out.println(tempFile.getParentFile().toString().replace("\\", "/"));
	}

}
