package socketTest.socketTest03.file.transfer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/*  
 * 客户端  
 *   
 * @author Tangtang  
 *  
 * 2015-6-16  
 */
public class Client {

	public static void main(String[] args) throws Exception {
		// 创建客户端
		Socket s = new Socket("127.0.0.1", 8888);

		// 创建要上传的文件对象
		InputStream input = new FileInputStream("F:\\b.txt");
		// 创建写入流
		OutputStream out = s.getOutputStream();

		// 自定义缓冲区
		byte[] buf = new byte[1024];

		int len = 0;
		while ((len = input.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		// 关闭输出流对象
		s.shutdownOutput();

		BufferedReader bufs = new BufferedReader(new InputStreamReader(s.getInputStream()));
		System.out.println(new String(bufs.readLine()));

		input.close();
		s.close();

	}

}