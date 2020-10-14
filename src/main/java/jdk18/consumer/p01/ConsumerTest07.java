package jdk18.consumer.p01;

import java.util.function.Consumer;

public class ConsumerTest07 {

	public static void main(String[] args) {
		ConsumerTest07Obj obj7 = new ConsumerTest07Obj();
		Consumer<ConsumerTest07Obj> consumer = kkk -> {
			obj7.haha();
		};
		consumer.accept(null);
	}

}

class ConsumerTest07Obj {

	public void haha() {
		System.out.println("haha");
	}

}