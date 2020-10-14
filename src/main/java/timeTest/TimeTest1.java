package timeTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest1 {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long time = new Long(1484621199);
		String d = format.format(time);
		Date date = format.parse(d);
		System.out.println("Format To String(Date):" + d);
		System.out.println("Format To Date:" + date);
	}

}
