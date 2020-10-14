package socketTest.socketTest03.file.transfer;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*  
 * 服务端  
 *   
 * 使用TCP协议写一个可以上传文件的服务器和客户端。  
 *   
 * @author Tangtang  
 *  
 * 2015-6-16  
 */
public class Server {

	public static void main(String[] args) throws Exception {
		// 创建服务端，并指定监听端口号
		ServerSocket ss = new ServerSocket(8888);

		// 获取客户端
		Socket s = ss.accept();

		// 获取客户端Ip
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "...连接成功！");

		// 得到客户端网络流(字节流文件)
		InputStream in = s.getInputStream();

		// 创建服务器端的写入流对象
		OutputStream out = new FileOutputStream("F:\\a.txt");

		// 定义缓冲区
		byte[] ch = new byte[1024];
		int len = 0;
		while ((len = in.read(ch)) != -1) {
			// 把客户端上传的文件写入到服务器中
			out.write(ch, 0, len);
		}

		// 返回给客户端的信息
		OutputStream outSoc = s.getOutputStream();

		outSoc.write("上传成功！".getBytes());

		out.close();
		s.close();
		ss.close();

	}

}