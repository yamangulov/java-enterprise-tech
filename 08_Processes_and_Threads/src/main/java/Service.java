import java.util.ArrayList;
import java.util.LinkedList;

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
}
