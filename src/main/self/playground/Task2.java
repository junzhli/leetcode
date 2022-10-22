package self.playground;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task2 implements Runnable {

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public Task2() {}

    @Override
    public void run() {

    }
}
