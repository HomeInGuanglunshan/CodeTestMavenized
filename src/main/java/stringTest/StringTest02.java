package stringTest;

public class StringTest02 {

	public static void main(String[] args) {
		String year_season_month = "2016s3";
		String p[] = year_season_month.split("s");
		int m = Integer.parseInt(p[1]);
		String mon3 = 3 * m > 10 ? p[1] : "0" + (3 * m);
		String mon2 = 3 * m - 1 > 10 ? p[1] : "0" + (3 * m - 1);
		String mon1 = 3 * m - 2 > 10 ? p[1] : "0" + (3 * m - 2);
		System.out.println(mon3 + "/" + mon2 + "/" + mon1 + "/");
	}

}
