package two;

import java.util.stream.Stream;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/6/15 21:04
 */

public class Peek {
    public static void main(String[] args) {
        Object[] powers = Stream.iterate(1.0, it -> it * 2)
                .peek(e -> System.out.println("Fetching " + e))
                .limit(10).toArray();
        for (Object object : powers)
            System.out.println(object);

    }
}
