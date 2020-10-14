package stringTest;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest08 {

	public static void main(String[] args) {
		String regex = "firewall zone (\\w+)((\\s|\\t)*)(\n)( set priority \\d*(\\s|\\t)*)(\n)(( add interface .+\n)*)";
		// String regex = "(firewall zone )(.*)";
		// ([\\s\\S]*) ((.*(\n))*)
		Pattern pattern = Pattern.compile(regex);
		String context = "#\ninterface GigabitEthernet0/0/0\n description to_N7K_trust                 \n ip address 192.168.60.10 255.255.255.248\n vrrp vrid 31 virtual-ip 192.168.60.11 master\n link-group 1\n#\ninterface GigabitEthernet0/0/1\n description to_DMZ_untrust\n ip address 192.168.60.5 255.255.255.248\n link-group 1\n#\ninterface GigabitEthernet0/0/2\n description to YunJiSuan_Fw_E1000E_01-GigabitEthernet0/0/2\n ip address 192.168.60.18 255.255.255.248\n vrrp vrid 1 virtual-ip 192.168.60.19 master\n#\ninterface GigabitEthernet0/0/3\n description for_admin\n ip address 172.16.20.185 255.255.255.192\n vrrp vrid 2 virtual-ip 172.16.20.183 master\n#\ninterface NULL0\n#";
		Matcher matcher = pattern.matcher(context);
		System.out.println(matcher.groupCount());
		int j = 1;
		while (matcher.find()) {
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(8));
			System.out.println("==================== result:" + j + " ====================");
			for (int i = 1; i <= matcher.groupCount(); i++) {
				System.out.println("group:" + i);
				System.out.println(matcher.group(i));
			}
			j++;
		}
		
//		String regex = "firewall zone (\\w+)(\n)(.*\n)(( add interface .+\n)*)((.*(\n))*)#";
//		// String regex = "(firewall zone )(.*)";
//		// ([\\s\\S]*)
//		Pattern pattern = Pattern.compile(regex);
//		String context = "firewall zone trust\n set priority 85\n#\n";
//		Matcher matcher = pattern.matcher(context);
//		while (matcher.find()) {
//			System.out.println(matcher.group(1));
//			System.out.println(matcher.group(4));
//		}

//		String regex = "add interface (.*)";
//		// String regex = "(firewall zone )(.*)";
//		// ([\\s\\S]*)
//		Pattern pattern = Pattern.compile(regex);
//		String context = " add interface GigabitEthernet0/0/0\n add interface GigabitEthernet0/0/2\n";
//		Matcher matcher = pattern.matcher(context);
//		while (matcher.find()) {
//			System.out.println(matcher.group(1));
//		}
		
//		String zone_interface = "GigabitEthernet0/0/2";
//		String regex = "interface " + zone_interface + "(\n)( description .*\n)(( ip address .+\n)*)((.*(\n))*)#";
//		// String regex = "(firewall zone )(.*)";
//		// ([\\s\\S]*)
//		Pattern pattern = Pattern.compile(regex);
//		String context = "#\ninterface GigabitEthernet0/0/0\n description to_N7K_trust                 \n ip address 192.168.60.10 255.255.255.248\n vrrp vrid 31 virtual-ip 192.168.60.11 master\n link-group 1\n#\ninterface GigabitEthernet0/0/1\n description to_DMZ_untrust\n ip address 192.168.60.5 255.255.255.248\n link-group 1\n#\ninterface GigabitEthernet0/0/2\n description to YunJiSuan_Fw_E1000E_01-GigabitEthernet0/0/2\n ip address 192.168.60.18 255.255.255.248\n vrrp vrid 1 virtual-ip 192.168.60.19 master\n#\ninterface GigabitEthernet0/0/3\n description for_admin\n ip address 172.16.20.185 255.255.255.192\n vrrp vrid 2 virtual-ip 172.16.20.183 master\n#\ninterface NULL0\n#";
//		Matcher matcher = pattern.matcher(context);
//		while (matcher.find()) {
//			System.out.println(matcher.group(3));
//		}
		
//		String regex = "\\s.*\\s";
//		// String regex = "(firewall zone )(.*)";
//		// ([\\s\\S]*)
//		Pattern pattern = Pattern.compile(regex);
//		String context = " add interface GigabitEthernet0/0/0\n add interface GigabitEthernet0/0/2\n";
//		Matcher matcher = pattern.matcher(context);
//		while (matcher.find()) {
//			System.out.println(matcher.group());
//		}
		
//		String str = "ip address 192.168.60.10 255.255.255.248";
//		System.out.println(str.split(" ")[2]);
		
//		String regex = "ip address (.+) (.+)";
//		// String regex = "(firewall zone )(.*)";
//		// ([\\s\\S]*)
//		Pattern pattern = Pattern.compile(regex);
//		String context = " ip address 192.168.60.18 255.255.255.248\n";
//		Matcher matcher = pattern.matcher(context);
//		while (matcher.find()) {
//			System.out.println(matcher.group(1));
//			System.out.println(matcher.group(2));
//		}
		
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("1", "11");
//		map.put("2", "22");
//		System.out.println(map);
		
//		String equipment_name = "sss";
//		String interface_address = "sss";
//		String interfaces = "sss";
//		String manage_ip = "sss";
//		String mask = "sss";
//		String subnet_network = "sss";
//		String _zone = "sss";
//		String userid = "sss";
//		String str = "insert into itil_firewall_define_server_port (equipment_name,interface_address,interfaces,manage_ip,mask,subnet_network,zone,status,create_user) "
//				+ "values ('"+equipment_name+"','"+interface_address+"','"+interfaces+"','"+manage_ip+"','"+mask+"','"+subnet_network+"','"+_zone+"',2,'"+userid+"')";
//		System.out.println(str);
		
//		String zone_interface = "GigabitEthernet2/0/0";
//		String regex = "(\\d+.\\d+.\\d+.\\d+/\\d+)(\t|\\s)*(\\w+)(\t|\\s)*(\\d+)(\t|\\s)*(\\d+)(\t|\\s)*(\\d+.\\d+.\\d+.\\d+)(\t|\\s)*" + zone_interface;
//		// String regex = "(firewall zone )(.*)";
//		// ([\\s\\S]*) (\t|\\s)*
//		Pattern pattern = Pattern.compile(regex);
//		String context = "1.1.1.0/24 Direct 0 0          1.1.1.1         GigabitEthernet2/0/0\ndescription to YunJiSuan_Fw_E1000E_01-GigabitEthernet2/0/0";
//		Matcher matcher = pattern.matcher(context);
//		while (matcher.find()) {
////			System.out.println(matcher.group().trim().split(" ")[0]);
//			System.out.println(matcher.group(1));
//		}
	}

}
