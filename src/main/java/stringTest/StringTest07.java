package stringTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest07 {

	public static void main(String[] args) {
//		String regex = " port \\d+ eq (.*)";
//		// String regex = "(firewall zone )(.*)";
//		// ([\\s\\S]*)
//		Pattern pattern = Pattern.compile(regex);
//		String context = " port 1 eq 50030\n port 2 eq www\n port 3 eq https\n port 4 eq 1527\n port 5 eq 2633\n port 6 eq 3306\n port 7 eq 3873\n port 8 eq 2222                           \n port 9 eq 6001\n port 10 eq 8009\n port 11 eq 8080\n port 12 eq 8443\n port 13 eq 8649\n port 14 eq 8651\n port 15 eq 6000\n port 16 eq 9090\n port 17 eq 9443\n port 18 eq 9673\n port 19 eq 9773\n port 20 eq 10000\n port 21 eq 27017\n port 22 eq 8652\n port 24 eq 50070\n port 25 eq 58080";
//		Matcher matcher = pattern.matcher(context);
//		while (matcher.find()) {
//			System.out.println(matcher.group(1));
//		}
		
//		String regex = "time-range (.*) from (\\d+:\\d+ \\d{4}/\\d+/\\d+) to (\\d+:\\d+ \\d{4}/\\d+/\\d+)";
//		// String regex = "(firewall zone )(.*)";
//		// ([\\s\\S]*)
//		Pattern pattern = Pattern.compile(regex);
//		String context = " time-range TA4616733 from 11:30 2016/5/5 to 23:30 2016/12/30\n time-range ap5193914 from 11:07 2016/12/27 to 23:59 2017/1/27\n time-range rhjftost from 14:48 2016/7/4 to 23:59 2016/9/30\nrule 1600 permit tcp source address-set stng3bossfep destination 10.252.18.1 0 destination-port port-set yaliceshi time-range TA4703880";
//		Matcher matcher = pattern.matcher(context);
//		while (matcher.find()) {
//			System.out.println(matcher.group(1) + matcher.group(2) + matcher.group(3));
//		}
		
//		String regex = "acl number (\\d+)(\n)(( description .*\n)*)(( rule \\d+ .*(\n)?)*)";
//		// String regex = "(firewall zone )(.*)";
//		// ([\\s\\S]*)
//		Pattern pattern = Pattern.compile(regex);
//		String context = "#\nacl number 3004\n description ssh_remote\n rule 0 permit ip source 10.243.211.2 0\n rule 1 permit ip source 10.243.212.2 0\n rule 2 permit ip source 10.251.149.105 0 \n rule 3 permit ip source 10.252.42.31 0\n rule 4 permit ip source 10.252.34.37 0\n rule 5 permit ip source 10.252.116.238 0 time-range AP4874868\n rule 6 permit ip source 10.252.116.237 0\n rule 8 permit ip source 10.252.20.29 0\n rule 11 permit ip source 10.252.18.1 0\n rule 12 permit ip source 10.252.18.2 0\n rule 13 permit ip source 10.244.150.141 0\n rule 14 permit ip source 10.251.149.95 0\n rule 15 permit ip source 10.252.42.20 0\n rule 18 permit ip source 10.244.143.76 0\n rule 19 permit ip source 10.243.224.252 0\n rule 30 permit ip source 10.252.116.111 0\n#\nacl number 3005\n description jixianzhenggai\n rule 5 deny udp destination-port eq netbios-ns\n rule 10 deny udp destination-port eq netbios-dgm\n rule 15 deny tcp destination-port eq 9996\n rule 20 deny tcp destination-port eq 9995\n rule 25 deny tcp destination-port eq 5554\n rule 30 deny udp destination-port eq 1434\n rule 35 deny udp destination-port eq 593 \n rule 40 deny tcp destination-port eq 593\n rule 45 deny tcp destination-port eq 445\n rule 50 deny udp destination-port eq 139\n rule 55 deny tcp destination-port eq netbios-ssn\n rule 60 deny udp destination-port eq rpc\n rule 65 deny tcp destination-port eq rpc\n rule 70 deny udp destination-port eq tftp\n rule 75 deny tcp destination-port eq 4444\n rule 80 deny udp destination-port eq 445\n rule 99 permit ip\n#\nacl number 3006\n rule 1 permit ip source 10.252.17.31 0 destination 10.252.179.47 0\n#\nacl number 3500\n#";
//		Matcher matcher = pattern.matcher(context);
//		while (matcher.find()) {
//			System.out.println(matcher.group(5));
//		}
		
//		String regex = "rule \\d+ (\\w*) (\\w*)(( source (\\d+.\\d+.\\d+.\\d+)+)*)(( (destination address-set|destination) ((\\d+.\\d+.\\d+.\\d+)+|(\\w+)))*)(( destination-port (range|eq) (\\w|-| )+ )*)(( time-range (\\w|-)+)*)";
//		// String regex = "(firewall zone )(.*)";
//		// ([\\s\\S]*)
//		Pattern pattern = Pattern.compile(regex);
//		String context = " rule 5 deny udp destination-port eq netbios-ns\n rule 10 deny udp destination-port eq netbios-dgm\n rule 15 deny tcp destination-port eq 9996\n rule 20 deny tcp destination-port eq 9995\n rule 25 deny tcp destination-port eq 5554\n rule 30 deny udp destination-port eq 1434\n rule 35 deny udp destination-port eq 593 \n rule 40 deny tcp destination-port eq 593\n rule 45 deny tcp destination-port eq 445\n rule 50 deny udp destination-port eq 139\n rule 55 deny tcp destination-port eq netbios-ssn\n rule 60 deny udp destination-port eq rpc\n rule 65 deny tcp destination-port eq rpc\n rule 70 deny udp destination-port eq tftp\n rule 75 deny tcp destination-port eq 4444\n rule 80 deny udp destination-port eq 445\n rule 99 permit ip\n rule 400 permit tcp source 10.252.156.128 0.0.0.127 destination address-set yx2jcj destination-port range ftp-data 22\n rule 401 permit tcp source 10.252.156.128 0.0.0.127 destination 10.252.18.1 0 destination-port port-set jfcj1\n rule 402 permit tcp source 10.252.156.128 0.0.0.127 destination address-set boss6 destination-port range ftp-data 22\n rule 405 permit tcp source 10.252.156.128 0.0.0.127 destination address-set ap4872363 destination-port range ftp-data 22\n rule 406 permit udp source address-set ap5053502 destination address-set time destination-port eq ntp\n rule 407 permit udp source address-set ap5059049 destination address-set time destination-port eq ntp\n rule 410 permit tcp source 10.252.156.128 0.0.0.127 destination address-set aphw4872363 destination-port range ftp-data 22\n rule 415 permit tcp source 10.252.156.128 0.0.0.127 destination 10.243.183.172 0 destination-port range ftp-data 22\n rule 420 permit tcp source 10.252.156.128 0.0.0.127 destination address-set ap5084657 destination-port range ftp-data 22\n rule 425 permit tcp source 10.252.156.128 0.0.0.127 destination 10.252.16.33 0 destination-port eq ftp\n rule 430 permit tcp source 10.252.156.128 0.0.0.127 destination address-set ap50846571 destination-port range ftp-data 22\n rule 9999 deny ip\n rule 425 permit tcp source 10.243.224.242 0 destination 10.252.156.252 0 time-range AP5112303time\n rule 426 permit tcp source 10.243.224.242 0 destination 10.252.156.253 0 time-range AP5112303time";
//		Matcher matcher = pattern.matcher(context);
//		while (matcher.find()) {
//			System.out.println(matcher.group());
//		}
		
//		String regex = "(source address-set (\\w|-| )+|((source (((\\d+\\.\\d+\\.\\d+\\.\\d+)|\\d+)( )?)+))+)( (destination address-set|destination-port|time-range))";
//		String regex = "(?<=(source address-set ))(.*)(?=(destination address-set ))|(?<=(source address-set ))(.*)(?=(destination ))|(?<=(source ))(.*)(?=(destination address-set ))|(?<=(source ))(.*)(?=(destination ))";
//		String regex = "(?<=(source address-set ))(.*)(?=(destination address-set ))";
		String regex = "time-range (\\w|-)+";
		// String regex = "(firewall zone )(.*)";
		// ([\\s\\S]*)
		Pattern pattern = Pattern.compile(regex);
		String context = " rule 3203 permit tcp source 10.251.149.95 0 destination address-set ap5205816 destination-port range ftp-data 22\n rule 3204 permit tcp source 10.251.149.105 0 destination address-set ap5205816 destination-port port-set ap52058161\n rule 3205 permit tcp source address-set bomc_source destination address-set ap5205816 destination-port range ftp-data 22\n rule 3206 permit tcp source address-set ap5031280sou destination address-set ap5209736 destination-port port-set ap5209736port\n rule 4000 permit tcp source address-set ng3qzd destination address-set qzdxbqzj destination-port port-set qzdport1\n rule 4005 permit tcp source 10.252.56.123 0 destination 10.252.20.236 0 destination-port port-set bomc\n rule 4406 permit tcp source 10.252.56.123 0 destination 10.252.18.1 0 destination-port eq 3389\n rule 4407 permit tcp source 10.245.35.18 0 destination address-set ap4946012 destination-port eq 9597\n rule 4408 permit tcp source 10.246.12.232 0 destination address-set ap4946012 destination-port eq 9597\n rule 4409 permit tcp source 10.246.12.233 0 destination address-set ap4946012 destination-port eq 9597\n rule 4410 permit tcp source 10.252.56.108 0 destination address-set ap5102714 destination-port port-set ds8kjk\n rule 4411 permit udp source 10.252.56.108 0 destination address-set ap5102714 destination-port range snmp snmptrap\n rule 6999 permit tcp source address-set newdccproxy destination address-set gzdgjmcbe destination-port range 6550 6575\n rule 7000 permit tcp source address-set newdccproxy destination address-set hwzmy_rbi destination-port range ftp-data 22\n rule 7001 permit tcp source address-set hwzmy_esop destination address-set hwzmy_crmdb destination-port eq sqlnet time-range hwcrmhk\n rule 7002 permit tcp source 172.18.189.110 0 destination address-set dgboss_abm destination-port range 6563 6583 time-range rptuat\n rule 7003 permit tcp source address-set hwzmy_esop destination address-set hwgdcrmcics destination-port eq 10020 time-range hwcrmhk\n rule 7004 permit tcp source 10.251.199.0 0.0.0.255 destination address-set bdywtc1 destination-port port-set bdywtc time-range RPTUAT\n rule 7005 permit tcp source 10.251.199.0 0.0.0.255 destination 10.252.21.109 0 destination-port port-set bdywtc time-range RPTUAT\n rule 7006 permit tcp source 10.251.199.0 0.0.0.255 destination 10.252.21.110 0 destination-port port-set bdywtc time-range RPTUAT\n rule 7007 permit udp source 10.252.34.36 0 destination 10.252.22.152 0 destination-port eq syslog time-range mt20181231\n rule 7009 permit ip source 10.243.224.242 0 destination address-set zyxhosts time-range AP3931979\n rule 7010 permit ip source 10.243.224.242 0 destination address-set cbejdyq time-range AP4571591\n rule 7050 permit ip source 10.243.224.240 0.0.0.7 destination address-set trust_hosts time-range APWF_4097301\n rule 7192 permit tcp source 10.246.55.242 0 destination address-set hwzmy_crmdb destination-port eq sqlnet time-range hwcrmhk";
		Matcher matcher = pattern.matcher(context);
		while (matcher.find()) {
//			System.out.println(matcher.groupCount());
			System.out.println(matcher.group().replace("time-range", "").trim());
		}
	}

}
