package volatileTest.p02;

public class VolatileTest {

//	private static volatile Target target = new Target(1024);
	private static Target target = new Target(1024);

	public static void main(String[] args) {

		for (int i = 0; i < 20; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (;;) {
						System.out.print(target.getSons()[0] > 0 ? "" : "");
//						System.out.print(target.getSons()[0] - 1 == 0 ? "" : "");
//						target.getSons()[0].toString();
					}
				}
			}).start();
		}

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (;;) {
					target = new Target(1024);
				}
			}
		}).start();

	}
}

class Target {

	Integer boys[];
	
	Integer girls[];

	Integer daughters[];
	
	Integer sons[];

	public Target(int n) {
		this.boys = new Integer[n];
		this.girls = new Integer[n];
		this.daughters = new Integer[n];
		this.sons = new Integer[n];
		sons[0] = 1;
	}

	public Integer[] getSons() {
		return sons;
	}

	public void setSons(Integer[] sons) {
		this.sons = sons;
	}

}