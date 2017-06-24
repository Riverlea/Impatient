package one;

import java.util.*;

public class Lambdas {
    public static void main(String[] args) {

        Runnable runner =
                () -> { for (int i = 0; i < 1000; i++) doWork(); };

        new Thread(runner).start();

//        Comparator<String> comp = ( first, second) -> first.compareTo(second);

        List<String>  list = new LinkedList<String>();
        list.add("RiverLea");
        list.add("Snow");
        list.add("Apple");
        list.add("Hello");

//        list.sort((first, last) -> Integer.compare(first.length(), last.length()));
        list.sort(Comparator.comparingInt(String::length));

        System.out.print(list);

/*
        comp =
                (String first, String second) -> {
                    if (first.length() < second.length()) return -1;
                    else if (first.length() > second.length()) return 1;
                    else return 0;
                };

        Runnable runner =
                () -> { for (int i = 0; i < 1000; i++) doWork(); };

        comp =
                (first, s econd) // Same as (String first, String second)
                       -> Integer.compare(first.length(), second.length());

        EventHandler<ActionEvent> listener = e -> System.out.println(e.getTarget());
        // Instead of (e) -> or (ActionEvent e) ->
*/
    }

    public static int i = 0;
    public static void doWork() {
        System.out.println("Hello World -->" + i++);
    }
}
