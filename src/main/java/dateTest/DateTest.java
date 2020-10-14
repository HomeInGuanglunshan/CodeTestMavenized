package dateTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTest {

	public static void main(String[] args) {
		System.out.println(DateTest.isValidDate("2016-01-02 15:34:34"));
		System.out.println(DateTest.formatDate("2016-01-02 15:34:34"));
	}

	public static boolean isValidDate(String str) {
		boolean convertSuccess = true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			// 设置lenient为false.
			// 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			e.printStackTrace();
			convertSuccess = false;
		}
		return convertSuccess;
	}

	public static long formatDate(String date) {
		long d = 0L;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// long times = System.currentTimeMillis();
			//d = new SimpleDateFormat("HH:mm").format(sdf.parse(date));
			//d = sdf.format(sdf.parse(date));
			d = sdf.parse(date).getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
}
