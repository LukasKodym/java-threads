package pl.lukas.threads;

public class App {

    public static void main(String[] args) {

        Thread thread = new MyThread("My-Thread-1");
        Thread secondThread = new MyThread("My-Thread-2");

        thread.start();
        secondThread.start();

        System.out.println("Główny wątek aplikacji " + Thread.currentThread().getName());
    }
}
