package dateSubtractionTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSubtractionTest02 {

	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date d1 = df.parse("2004-03-26 13:31:40");
			Date d2 = df.parse("2004-03-26 14:40:24");
			long diff = d2.getTime() - d1.getTime();// 这样得到的差值是毫秒级别
			diff = diff / 1000; // 这样得到的差值是毫秒级别
			long hours = diff / 3600;
			long minutes = (diff % 3600) / 60;
			long seconds = (diff % 3600) % 60;
			System.out.println(hours + "h" + minutes + "min" + seconds + "s");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
