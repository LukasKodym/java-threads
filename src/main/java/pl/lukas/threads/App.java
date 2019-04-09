package pl.lukas.threads;

public class App {

    public static void main(String[] args) {

        Thread thread = new MyThread("My-Thread-1");

        thread.start();

        System.out.println("Główny wątek aplikacji " + Thread.currentThread().getName());


    }

}
