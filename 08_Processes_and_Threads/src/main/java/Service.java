import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Andrey.Yamangulov
 * Date: 25.07.2021
 * Time: 9:53
 */
public class Service {
    private Integer count = 0;
    private final LinkedList<String> log = new LinkedList<>();

    public synchronized void log() {
        count = count + 1;
        log.add(Thread.currentThread().getName());
    }

    public synchronized void debug() {
        System.out.println(count);
        log.forEach(System.out::println);
    }

    public synchronized static void runThreadsAndCallMethods(int threads, int calls) {
        Service innerCounter = new Service();
        Lock lock = new ReentrantLock();
        List<Thread> threadList = IntStream.rangeClosed(1, threads).mapToObj(
                thread -> {

                    Thread t = new Thread(() -> {
                        lock.lock();
                        IntStream.rangeClosed(1, calls).forEach(
                                call -> innerCounter.log()
                        );
                        lock.unlock();
                    }, "T" + thread);

                    t.start();
                    return t;
                }
        ).collect(Collectors.toList());
        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        innerCounter.debug();
    }
}
