package stringTest;

public class StringTest01 {
	public static void main(String[] args) {
		String str = "iwant--sdl";
		System.out.println(str.substring(str.lastIndexOf("-") + 1));
	}
}
