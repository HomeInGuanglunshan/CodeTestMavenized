package regTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {

	public static void main(String[] args) {
		String regex = "(Mon|(Tues|Tue)|Wed|(Thur|Thu)|Fri|Sat|Sun) (Jan|Feb|Mar|Apr|May|Jun|(Jul|July|Jy)|Aug|(Sep|Sept)|Oct|Nov|Dec) \\d{2} \\d{2}:\\d{2}:\\d{2} \\d{4}";
		Pattern pattern = Pattern.compile(regex);
		String context = "2464546@qq.com Fri Dec 02 08:26:59 2016 TNS-00505: Operation timed out     nt secondary err code: 110     nt OS err code: 0   Client address: (ADDRESS=(PROTOCOL=tcp)(HOST=192.168.10.151)(PORT=52017)) Tue Nov 29 23:06:39 2016 Thread 1 advanced to log sequence 1109 (LGWR switch)   Current log# 2 seq# 1109 mem# 0: /home/oracle11_2/db/oradata/ora11g/redo02.log Wed Nov 30 03:55:02 2016 Thread 1 advanced to log sequence 1110 (LGWR switch)   Current log# 3 seq# 1110 mem# 0: /home/oracle11_2/db/oradata/ora11g/redo03.log Wed Nov 30 08:20:47 2016 Thread 1 advanced to log sequence 1111 (LGWR switch)   Current log# 1 seq# 1111 mem# 0: /home/oracle11_2/db/oradata/ora11g/redo01.log Wed Nov 30 08:57:49 2016 Thread 1 advanced to log sequence 1112 (LGWR switch)   Current log# 2 seq# 1112 mem# 0: /home/oracle11_2/db/oradata/ora11g/redo02.log Wed Nov 30 13:35:11 2016 Thread 1 advanced to log sequence 1113 (LGWR switch)   Current log# 3 seq# 1113 mem# 0: /home/oracle11_2/db/oradata/ora11g/redo03.log Wed Nov 30 18:12:14 2016 Thread 1 advanced to log sequence 1114 (LGWR switch)   Current log# 1 seq# 1114 mem# 0: /home/oracle11_2/db/oradata/ora11g/redo01.log Wed Nov 30 20:24:40 2016";
		Matcher matcher = pattern.matcher(context);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
