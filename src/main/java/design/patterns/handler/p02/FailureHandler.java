package design.patterns.handler.p02;

public interface FailureHandler {

	void onFailure(long duration, Exception exception, Integer result);

}
