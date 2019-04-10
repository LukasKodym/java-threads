package pl.lukas.threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletableFuture.runAsync(
                () -> System.out.println("Wątek: " + Thread.currentThread().getName()),
                executor
        );

        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 42;
                },
                executor);

        Integer bar = result.get();

        System.out.println((bar * 2) + 1);

        executor.shutdown();
    }
}