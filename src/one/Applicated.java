package one;


import java.util.Comparator;


public class Applicated {
    public static void main(String[] args) {

        // Path first = Paths.get("/usr/bin");
        // Uncomment to see error "variable first is already defined"
        // in the lambda expression below

        Comparator<String> comp =
                Comparator.comparingInt(String::length);
        Applicated app = new Applicated();
        app.doWork();
    }

    public void doWork() {
        Runnable runner = () -> System.out.println(this.toString());
        runner.run();
        // Prints Application@... since this refers to an Application object
    }
}
