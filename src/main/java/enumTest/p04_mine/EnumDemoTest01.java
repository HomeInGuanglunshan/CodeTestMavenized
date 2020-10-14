package enumTest.p04_mine;

public class EnumDemoTest01 {

	public static void main(String[] args) {
		for (Season season : Season.values()) {
			System.out.println(season + season.getSeasonAttr());
		}
		System.out.print(Season.getSeason(1));
		System.out.println(Season.SPRING.getSeasonAttr());
	}
}

enum Season {

	SPRING(" is wet"), SUMMER(" is hot"), AUTUMN(" is cool"), WINTER(" is cold");

	private final String seasonAttr;

	private Season(String seasonAttr) {
		this.seasonAttr = seasonAttr;
	}

	public static Season getSeason(int i) {
		switch (i) {
		case 1:
			return Season.SPRING;
		case 2:
			return Season.SUMMER;
		case 3:
			return Season.AUTUMN;
		case 4:
			return Season.WINTER;
		default:
			return null;
		}
	}

	public String getSeasonAttr() {
		return seasonAttr;
	}
}
