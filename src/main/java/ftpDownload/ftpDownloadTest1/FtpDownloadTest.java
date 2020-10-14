package ftpDownload.ftpDownloadTest1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class FtpDownloadTest {

	public static void main(String[] args) {
		try {
			boolean flag = downFile("192.168.11.50", 2121, "admin", "admin", "/home/ampmon", "deploy.sh", "F:/");
			System.out.println(flag);
			// listFileNames("192.168.11.50", 22, "root", "itc123!@#", "/root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static List<String> listFileNames(String host, int port, String username, final String password,
			String dir) {
		List<String> list = new ArrayList<String>();
		ChannelSftp sftp = null;
		Channel channel = null;
		Session sshSession = null;
		try {
			JSch jsch = new JSch();
			jsch.getSession(username, host, port);
			sshSession = jsch.getSession(username, host, port);
			sshSession.setPassword(password);
			Properties sshConfig = new Properties();
			sshConfig.put("StrictHostKeyChecking", "no");
			sshSession.setConfig(sshConfig);
			sshSession.connect();
			// LOG.debug("Session connected!");
			channel = sshSession.openChannel("sftp");
			channel.connect();
			// LOG.debug("Channel connected!");
			sftp = (ChannelSftp) channel;
			Vector<?> vector = sftp.ls(dir);
			for (Object item : vector) {
				LsEntry entry = (LsEntry) item;
				System.out.println(entry.getFilename());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeChannel(sftp);
			closeChannel(channel);
			closeSession(sshSession);
		}
		return list;
	}

	private static void closeChannel(Channel channel) {
		if (channel != null) {
			if (channel.isConnected()) {
				channel.disconnect();
			}
		}
	}

	private static void closeSession(Session session) {
		if (session != null) {
			if (session.isConnected()) {
				session.disconnect();
			}
		}
	}

	public static boolean downFile(String url, // FTP服务器hostname
			int port, // FTP服务器端口
			String username, // FTP登录账号
			String password, // FTP登录密码
			String remotePath, // FTP服务器上的相对路径
			String fileName, // 要下载的文件名
			String localPath// 下载后保存到本地的路径
	) {
		boolean success = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(url, port);
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(username, password);// 登录
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return success;
			}
			ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
			FTPFile[] fs = ftp.listFiles();
			for (FTPFile ff : fs) {
				if (ff.getName().equals(fileName)) {
					File localFile = new File(localPath + "/" + ff.getName());
					OutputStream is = new FileOutputStream(localFile);
					ftp.retrieveFile(ff.getName(), is);
					is.close();
				}
			}

			ftp.logout();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return success;
	}
}