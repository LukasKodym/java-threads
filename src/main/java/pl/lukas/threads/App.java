package pl.lukas.threads;

import java.util.concurrent.*;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(5);


        CompletableFuture<Long> cfuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 32L;
        });

        CompletableFuture<Long> cfuture2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2L;
        });

        CompletableFuture<Long> longCompletableFuture =
                cfuture1.thenCombine(cfuture2, (result1, result2) -> result1 * result2);

        Long aLong = longCompletableFuture.get();

        System.out.println(aLong);

        executor.shutdown();
    }

    public static Long getUserId() {
        return 324L;
    }

    public static Double getDiscount(Long userId) {
        return 0.15;
    }
}