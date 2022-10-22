package self.playground;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    private final BlockingQueue<Callable> queue;

    public Producer(BlockingQueue<Callable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
    }
}
