package pl.lukas.threads;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Wykonywany wątek (runnable) " + Thread.currentThread().getName());
    }
}
