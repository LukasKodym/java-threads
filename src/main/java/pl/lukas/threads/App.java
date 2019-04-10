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

//        while (!result.isDone()) {
//            System.out.println("Brak wyniku");
//            TimeUnit.SECONDS.sleep(2);
//        }

        Integer r = null;
        try {
            r = result.get(4, TimeUnit.SECONDS);
            System.out.println(r);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


        executor.shutdown();
    }
}