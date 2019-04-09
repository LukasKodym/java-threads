package pl.lukas.threads;

public class App {

    public static void main(String[] args) {

        System.out.println("Główny wątek aplikacji " + Thread.currentThread().getName());
        Thread thread = new MyThread("My-Thread-1");
        thread.start();

        Runnable runnable = () -> {
            try {
                System.out.println("Wykonywany wątek (runnable) "
                        + Thread.currentThread().getName());
                for (int i = 0; i <= 10; i++) {
                    System.out.println(i);

                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread anotherThread = new Thread(runnable, "My-Runnable-1");
        anotherThread.start();
    }
}