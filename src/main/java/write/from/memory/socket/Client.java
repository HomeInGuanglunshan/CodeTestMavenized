package write.from.memory.socket;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception {
		Socket s = new Socket("127.0.0.1", 8888);
		InputStream in = new FileInputStream("F:/a.txt");
		OutputStream out = s.getOutputStream();
		byte[] ch = new byte[1024];
		int len = 0;
		while ((len = in.read(ch)) != -1) {
			out.write(ch, 0, len);
		};
		s.shutdownOutput();
		BufferedReader bufs = new BufferedReader(new InputStreamReader(s.getInputStream()));
		System.out.println(bufs.readLine());
		in.close();
		s.close();
	}

}
