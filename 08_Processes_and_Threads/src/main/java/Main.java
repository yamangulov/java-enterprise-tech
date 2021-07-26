/**
 * Created by Andrey.Yamangulov
 * Date: 25.07.2021
 * Time: 11:01
 */
public class Main {
    public static void main(String[] args) {
        // задача 1
        var counter = new Service();
        counter.log();
        counter.debug();

        // задача 2
        Service.runThreadsAndCallMethods(3, 10);
    }
}
