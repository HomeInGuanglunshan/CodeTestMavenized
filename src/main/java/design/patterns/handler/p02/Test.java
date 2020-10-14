package design.patterns.handler.p02;

public class Test {

	public static void main(String[] args) throws Exception {
		TellMeResult tellMeResult = new TellMeResult();
		tellMeResult.setFailureHandler((duration, exception, result) -> {
			System.out.println("=-----------------------------");
			System.out.println(exception.getMessage());
			System.out.println("The true answer is " + result);
			System.out.println("It took you " + new Float(duration) / 1000 + " seconds");
			System.out.println("-----------------------------=");
		});
		tellMeResult.setSuccessHandler((duration) -> {
			System.out.println("=-----------------------------");
			System.out.println("Bingo!");
			System.out.println("It took you " + new Float(duration) / 1000 + " seconds");
			System.out.println("-----------------------------=");
		});
		tellMeResult.execute();
	}

}
