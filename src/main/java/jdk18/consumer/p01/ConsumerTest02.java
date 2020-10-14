package jdk18.consumer.p01;

import java.util.function.Consumer;

public class ConsumerTest02 {

	public static void printInfo(String[] arr, Consumer<String> con1, Consumer<String> con2) {
		for (String message : arr) {
			con1.andThen(con2).accept(message);
		}
	}

	public static void main(String[] args) {
		String[] arr = { "迪丽热巴，女", "古力娜扎，女", "马尔扎哈，男" };
		printInfo(arr, (msg) -> {
			String name = msg.split("，")[0];
			System.out.println("姓名：" + name);
		}, (msg) -> {
			String sex = msg.split("，")[1];
			System.out.println("性别：" + sex);
		});
	}

}
