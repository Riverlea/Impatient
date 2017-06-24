package one;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/6/15 20:38
 */

public class StaticInterfaceMethods {
    public static void main(String[] args) {
        Greeter worldGreeter = Greeter.newInstance("World");
        System.out.println(worldGreeter.greet());
    }
}

interface Greeter {
    String greet();

    static Greeter newInstance(String greeted) {
        return () -> "Hello, " + greeted;
    }
}
