package stringTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String regex = "(\\w|-| )+";
//		// String regex = "(firewall zone )(.*)";
//		// ([\\s\\S]*) ip port-set (\\w+) protocol (\\w+)(\n)( port \\d+ eq .*(\n))*
//		Pattern pattern = Pattern.compile(regex);
//		String context = "ip port-set gongzhongyun protocol tcp\n port 1 eq ftp\n port 2 eq 4489\n port 3 eq 8080\nip port-set yundangan protocol tcp\n port 1 eq ftp                            \n port 2 eq 2222\n port 3 eq telnet\n port 4 eq 3306\n port 5 eq 4489\n port 6 eq 8080\n port 7 eq 8081\nip port-set cloudmaster1 protocol tcp\n port 1 eq 2222\n port 2 eq www\n port 3 eq https\n port 4 eq 1527\n port 5 eq 2633\n port 6 eq 3306\n port 7 eq 3873\n port 8 eq 8080\n port 9 eq 8082\n port 10 eq 5000\n port 11 eq 6000\n port 12 eq 6001\n port 13 eq 8009\n port 14 eq 8081\n port 16 eq 4848\n port 17 eq 8161                          \n port 18 eq 8443\n port 19 eq 8649\n port 20 eq 8651\n port 21 eq 8652\n port 22 eq 8083\n port 23 eq 9443\n port 24 eq 9673\n port 25 eq 9773\n port 26 eq 10000\n port 27 eq 27017\n port 28 eq 28017\n port 29 eq 9090\n port 30 eq 50070\n port 31 eq 58080\nip port-set onest protocol tcp\n port 1 eq 50030\n port 2 eq www\n port 3 eq https\n port 4 eq 1527\n port 5 eq 2633\n port 6 eq 3306\n port 7 eq 3873\n port 8 eq 2222                           \n port 9 eq 6001\n port 10 eq 8009\n port 11 eq 8080\n port 12 eq 8443\n port 13 eq 8649\n port 14 eq 8651\n port 15 eq 6000\n port 16 eq 9090\n port 17 eq 9443\n port 18 eq 9673\n port 19 eq 9773\n port 20 eq 10000\n port 21 eq 27017\n port 22 eq 8652\n port 24 eq 50070\n port 25 eq 58080";
//		Matcher matcher = pattern.matcher(context);
//		while (matcher.find()) {
//			System.out.println(matcher.group());
//		}
		
//		String team_sql = "select " + "kk" + " as team union all ";
//		team_sql += "select " + "bb" + " as team union all ";
//		System.out.println(team_sql.replaceAll(" union all $", ""));
		
		String regex = "^once.*";
		Pattern pattern = Pattern.compile(regex);
		String context = "once upon a time\nThere once was a man from NewYork";
		Matcher matcher = pattern.matcher(context);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
