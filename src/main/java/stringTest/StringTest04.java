package stringTest;

public class StringTest04 {

	public static void main(String[] args) {
		String name = "13213--";
		String ip = "";
		if (name.indexOf("--") != -1 && name.split("--").length == 2) {
			ip = name.split("--")[1];
		}
		System.out.println(ip);
	}

}
