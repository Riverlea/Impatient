package one;

/**
 * Created by 李小河 on 2017/6/15.
 */

public class SuperTest {
    public static void main(String[] args) {
        class Greeter {
            public void greet() {
                System.out.println("Hello, world!");
            }
        }

        class ConcurrentGreeter extends Greeter {
            public void greet() {
                Thread t = new Thread(super::greet);
                t.start();
            }
        }

        new ConcurrentGreeter().greet();
    }
}
