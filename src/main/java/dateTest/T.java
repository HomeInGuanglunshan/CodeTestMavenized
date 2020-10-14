package dateTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class T {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date date = new Date();
		System.out.println(sdf.format(date));
		System.out.println(sdf.format(getLastDate(date)));
		System.out.println(sdf.format(getLastDate(date)));
	}

	private static Date getLastDate(Date date) {
		Calendar cal = Calendar.getInstance();
		// cal.setTime(date);
		cal.add(Calendar.MONTH, -1);
		return cal.getTime();
	}
}