package design.patterns.handler.p02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class TellMeResult {

	FailureHandler failureHandler;

	SuccessHandler successHandler;

	public void setFailureHandler(FailureHandler failureHandler) {
		this.failureHandler = failureHandler;
	}

	public void setSuccessHandler(SuccessHandler successHandler) {
		this.successHandler = successHandler;
	}

	public Integer quiz() throws Exception {
		Random random = new Random();
		Integer a = random.nextInt(10);
		Integer b = random.nextInt(10);
		String operation = null;
		Integer result = null;
		switch (random.nextInt(4)) {
		case 0:
			operation = " + ";
			result = a + b;
			break;
		case 1:
			operation = " - ";
			result = a - b;
			break;
		case 2:
			operation = " * ";
			result = a * b;
			break;
		case 3:
			if (b != 0) {
				operation = " / ";
				result = a / b;
			} else {
				operation = " + ";
				result = a + b;
			}
			break;
		}
		System.out.println(a + operation + b + " = ?");
		return result;
	}

	public void execute() throws Exception {
		for (;;) {
			Integer result = quiz();

			Long beginTime = System.currentTimeMillis();

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String input = reader.readLine();

			Integer integerInput = null;
			try {
				integerInput = new Integer(input);
			} catch (Exception e) {
				failureHandler.onFailure(System.currentTimeMillis() - beginTime, new Exception("Invalid input!"),
						result);
				continue;
			}
			if (!result.equals(integerInput)) {
				failureHandler.onFailure(System.currentTimeMillis() - beginTime, new Exception("Wrong answer!"),
						result);
				continue;
			}

			successHandler.onSuccess(System.currentTimeMillis() - beginTime);
		}
	}

}
