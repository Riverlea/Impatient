package three;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/6/20 13:48
 */

import java.util.function.*;

public class Parameters {
    public static void main(String[] args) {
        repeat(10, i -> System.out.println("Countdown: " + (9 - i)));
        repeat(10, () -> System.out.println("Hello, World!"));
    }

    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) action.accept(i);
    }

    public static void repeat(int n, Runnable action) {
        for (int i = 0; i < n; i++) action.run();
    }
}

