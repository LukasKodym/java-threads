package pl.lukas.threads;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("wykonywany wątek " + Thread.currentThread().getName());
    }
}
