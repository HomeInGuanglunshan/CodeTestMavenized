package url;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * URLpost请求方法<br>
 * refer to: https://blog.csdn.net/weixin_38824230/article/details/78411703
 *
 * @author zhangyu
 */
public class URLConnectionUtil {
	/**
	 * 开放平台接口的请求方法
	 */
	public static String readContentFromPost(String url, String requestCode, String platform, String params)
			throws IOException {
		String Result = "";
		// Post请求的url，与get不同的是不需要带参数
		URL postUrl = new URL(url);
		// 打开连接
		HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();

		// 设置是否向connection输出，因为这个是post请求，参数要放在
		// http正文内，因此需要设为true
		connection.setDoOutput(true);
		// Read from the connection. Default is true.
		connection.setDoInput(true);
		// 默认是 GET方式
		connection.setRequestMethod("POST");

		// Post 请求不能使用缓存
		connection.setUseCaches(false);

		connection.setInstanceFollowRedirects(true);
		// 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
		// 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
		// 进行编码
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		// 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
		// 要注意的是connection.getOutputStream会隐含的进行connect。
		connection.connect();
		DataOutputStream out = new DataOutputStream(connection.getOutputStream());
		// The URL-encoded contend
		// 正文，正文内容其实跟get的URL中 '? '后的参数字符串一致
		String content = "requestCode=" + URLEncoder.encode(requestCode, "UTF-8");
		content += "&platform=" + URLEncoder.encode(platform, "UTF-8");
		content += "&params=" + URLEncoder.encode(params, "UTF-8");

		// DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写到流里面
		out.writeBytes(content);
		out.flush();
		out.close();

		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line = "";
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
			Result = line;
		}
//		reader.close();
//		connection.disconnect();
		return Result;
	}

	public static void main(String[] args) {

	}
}