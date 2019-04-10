package pl.lukas.threads;


import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {

        Callable<Integer> answerToEverthing = new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(10);
                return 42;
            }
        };

    }
}