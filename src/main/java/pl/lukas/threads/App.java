package pl.lukas.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {

        Callable<Integer> answerToEverything = () -> {
            TimeUnit.SECONDS.sleep(10);
            return 42;
        };


    }
}