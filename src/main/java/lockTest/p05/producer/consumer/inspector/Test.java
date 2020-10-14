package lockTest.p05.producer.consumer.inspector;

public class Test {

	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse(5, 10);
		new Producer(warehouse, "Produce1").start();
		new Producer(warehouse, "Produce2").start();
		new Producer(warehouse, "Produce3").start();
		new Consumer(warehouse, "Consumer1").start();
		new Consumer(warehouse, "Consumer2").start();
		new Inspector(warehouse, "Inspector1").start();
		new Inspector(warehouse, "Inspector2").start();
	}
}
