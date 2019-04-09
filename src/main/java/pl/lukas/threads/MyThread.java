package pl.lukas.threads;

import java.util.stream.IntStream;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {

        IntStream.rangeClosed(1, 20).forEach(value ->
                System.out.println(value + " | wykonywany wątek " + Thread.currentThread().getName())
        );
    }
}
