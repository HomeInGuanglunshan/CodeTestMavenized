package ipTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPTest {

	public static void main(String[] args) {
		InetAddress addr;
		try {
			addr = InetAddress.getLocalHost();
			String sourceIP = addr.getHostAddress().toString();
			System.out.println(sourceIP);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
