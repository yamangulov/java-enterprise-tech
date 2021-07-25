import java.util.ArrayList;
import java.util.LinkedList;
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
        IntStream.rangeClosed(1, threads).forEach(
                thread -> {
                    Thread t = new Thread(() -> {
                        IntStream.rangeClosed(1, calls).forEach(
                                call -> innerCounter.log()
                        );
                    }, "T" + thread);
                    t.start();
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        innerCounter.debug();
    }
}
