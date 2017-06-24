package one;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date   2017/6/15 20:38
 */

interface Person {
    long getId();
    default String getName() { return "John Q. Public"; }
}

interface Persistent {
    default String getName() { return getClass().getName() + "_" + hashCode(); }
}

public class Student implements Person, Persistent {
    public long getId() { return 42; }
    public String getName() { return Person.super.getName(); }
}

