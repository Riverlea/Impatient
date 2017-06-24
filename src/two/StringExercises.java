package two;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class StringExercises {

    // Question 7
    public static int countLowercaseLetters(String string) {
        return (int) string.chars()
                .filter(Character::isLowerCase)
                .count();
    }

    // Question 8
    public static Optional<String> mostLowercaseString(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparingInt(StringExercises::countLowercaseLetters));
    }

}



class MapUsingReduce {

    public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
        return stream.reduce(new ArrayList<O>(), (acc, x) -> {
            // We are copying data from acc to new list instance. It is very inefficient,
            // but contract of Stream.reduce method requires that accumulator function does
            // not mutate its arguments.
            // Stream.collect method could be used to implement more efficient mutable reduction,
            // but this exercise asks to use reduce method.
            List<O> newAcc = new ArrayList<>(acc);
            newAcc.add(mapper.apply(x));
            return newAcc;
        }, (List<O> left, List<O> right) -> {
            // We are copying left to new list to avoid mutating it.
            List<O> newLeft = new ArrayList<>(left);
            newLeft.addAll(right);
            return newLeft;
        });
    }

    public static void main(String[] args) {
//        List<String> listOne = new ArrayList<>();
//        List<String> listTwo = new ArrayList<>();
//        listOne.add("River");
//        listOne.add("Snow");
//        listTwo.addAll(listOne);
//
//        List<List<String>> lists = new ArrayList<>();
//        lists.add(listOne);
//        lists.add(listTwo);
//
//        System.out.print(lists);
//
//        Stream<List<String>> stream = lists.stream();
//        List<String> list = stream.reduce(
//                new ArrayList<String>(),
//                (acc, x) -> {
//                    List<String> newAcc = new ArrayList<>(acc);
//                    newAcc.addAll(x);
//                    return newAcc;
//                } , (List<String> left, List<String> right) -> {
//                    List<String> newLeft = new ArrayList<>(left);
//                    newLeft.addAll(right);
//                    return newLeft;
//                }
//        );
//        System.out.println(list);





    }



}
