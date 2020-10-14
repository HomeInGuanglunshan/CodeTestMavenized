package callable.future.Test.p05;
import java.util.concurrent.*;

/**
 * https://blog.csdn.net/u012664375/article/details/66967687
 *
 */
public class Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("call");
                TimeUnit.SECONDS.sleep(1);
                return "str";
            }
        });
        System.out.println(future.get());
    }
}