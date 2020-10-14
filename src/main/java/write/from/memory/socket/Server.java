package write.from.memory.socket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(8888);
		Socket s = ss.accept();
		InputStream in = s.getInputStream();
		OutputStream out = new FileOutputStream("F:/b.txt");
		byte[] ch = new byte[1024];
		int len = 0;
		while ((len = in.read(ch)) != -1) {
			out.write(ch, 0, len);
		};
		s.getOutputStream().write("上传成功".getBytes());;
		out.close();
		s.close();
		ss.close();
	}

}
