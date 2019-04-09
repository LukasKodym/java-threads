package pl.lukas.threads;

public class App {

    public static void main(String[] args) {

        System.out.println("Główny wątek aplikacji " + Thread.currentThread().getName());

        Thread thread = new MyThread("My-Thread-1");

        thread.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Wykonywany wątek (runnable) " + Thread.currentThread().getName());

            }
        };

        Thread anotherThread = new Thread(runnable, "My-Runnable-1");

        anotherThread.start();


    }
}
