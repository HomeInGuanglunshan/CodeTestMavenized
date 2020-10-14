package sftpDownloadTest;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jfinal.kit.PathKit;

public class SFtpDownloadTest {

	public static Logger logger = Logger.getLogger(SFtpDownloadTest.class);

	public static void main(String[] args) {
		String fileName = "deploy.sh";
		String source = "/home/ampmon";
		String real_path = "F:/" + fileName;
		ChannelSftp sftp = connect("192.168.11.50", 22, "root", "itc123!@#");// 连接FTP服务器
		boolean sussess = download(source, fileName, real_path, sftp);// 下载到临时位置
		System.out.println(sussess);
	}

	/**
	 * 下载文件
	 * 
	 * @param directory
	 *            下载目录
	 * @param downloadFile
	 *            下载的文件名
	 * @param saveFile
	 *            存在本地的路径
	 * @param sftp
	 *            sftp连接器
	 */
	public static boolean download(String directory, String downloadFile, String saveFile, ChannelSftp sftp) {
		boolean flag = true;
		try {
			sftp.cd(directory); // cd到目录
			File file = new File(saveFile);
			sftp.get(downloadFile, new FileOutputStream(file));
		} catch (Exception e) {
			flag = false;
			logger.error("下载文件失败", e);
		}
		return flag;
	}

	/**
	 * 连接sftp服务器
	 * 
	 * @param host
	 *            主机
	 * @param port
	 *            端口
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 */
	public static ChannelSftp connect(String host, int port, String username, String password) {
		ChannelSftp sftp = null;
		try {
			JSch jsch = new JSch();
			jsch.getSession(username, host, port);
			Session sshSession = jsch.getSession(username, host, port);
			System.out.println("Session created.");
			sshSession.setPassword(password);
			Properties sshConfig = new Properties();
			sshConfig.put("StrictHostKeyChecking", "no");
			sshSession.setConfig(sshConfig);
			sshSession.connect();
			Channel channel = sshSession.openChannel("sftp");
			channel.connect();
			sftp = (ChannelSftp) channel;
		} catch (Exception e) {
			logger.error("连接Ftp失败");
		}
		return sftp;
	}
}
