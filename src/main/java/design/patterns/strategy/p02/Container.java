package design.patterns.strategy.p02;

import java.util.Random;

public abstract class Container {

	public void getContainerStatus() {
		Random random = new Random();
		for (;;) {
			float temperature = (random.nextInt(2) == 0 ? 1 : -1) * random.nextInt(10) / 10f + 25;
			float humidity = (random.nextInt(2) == 0 ? 1 : -1) * random.nextInt(10) / 10f + 60;
			System.out.println("Container status [Temperature: " + temperature + "℃ | Humidity: " + humidity + "%]");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
