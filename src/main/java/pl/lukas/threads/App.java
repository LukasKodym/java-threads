package pl.lukas.threads;

import java.util.concurrent.*;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> answerToEverything = () -> {
            TimeUnit.SECONDS.sleep(10);
            return 42;
        };

        Future<Integer> result = executor.submit(answerToEverything);

        Integer r = result.get();

        System.out.println(r);

        executor.shutdown();
    }
}