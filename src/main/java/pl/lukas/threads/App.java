package pl.lukas.threads;

public class App {

    public static void main(String[] args) {

        System.out.println("Główny wątek aplikacji " + Thread.currentThread().getName());

        Thread thread = new MyThread("My-Thread-1");

        thread.start();

        Thread anotherThread = new Thread(() -> System.out.println("Wykonywany wątek (runnable) "
                + Thread.currentThread().getName()), "My-Runnable-1");

        anotherThread.start();
    }
}