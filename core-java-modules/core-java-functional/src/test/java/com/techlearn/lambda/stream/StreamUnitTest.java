package com.techlearn.lambda.stream;

import com.google.common.base.Supplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamUnitTest {

    @Test
    void createStream() {
        Stream<String> empty = Stream.empty(); // count = 0
        Stream<Integer> singleElement = Stream.of(1); // count = 1
        Stream<Integer> fromArray = Stream.of(1, 2, 3); // count = 2
        Stream<Double> randoms = Stream.generate(Math::random); //infinite stream
    }

    @Test
    void terminalOperator() {
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        //count()
        assertEquals(3, s.count());

        //min() and max()
        Stream<String> st1 = Stream.of("monkey", "gorilla", "bonobo");
        Optional<String> min = st1.min(Comparator.comparingInt(String::length));
        min.ifPresent(System.out::println);

        //findAny() and findFirst()
        Stream<String> s2 = Stream.of("monkey", "gorilla", "bonobo");
        Stream<String> infinite = Stream.generate(() -> "chimp");

        s2.findAny().ifPresent(System.out::println); // monkey
        infinite.findAny().ifPresent(System.out::println); // chimp

        //allMatch() , anyMatch() and noneMatch()
        List<String> list = Arrays.asList("monkey", "2", "chimp");
        Stream<String> infinite1 = Stream.generate(() -> "chimp");

        Predicate<String> predicate = x -> Character.isLetter(x.charAt(0));
        assertEquals(true, list.stream().anyMatch(predicate));
        assertEquals(false, list.stream().allMatch(predicate));
        assertEquals(false, list.stream().noneMatch(predicate));

        //forEach()
        list.stream().forEach(System.out::print);
    }

    @Test
    void terminalOperatorReduce() {
        //The reduce() method combines a stream into a single object.
        /*
        Method Signature :::::::

        T reduce(T identity, BinaryOperator<T> accumulator)
        Optional<T> reduce(BinaryOperator<T> accumulator)
        <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
         */

        Stream<String> stream = Stream.of("w", "o", "l", "f");
        String reduce = stream.reduce("", (a, b) -> a + b);
        assertEquals("wolf", reduce);

        Stream<Integer> streamNum = Stream.of(2, 3, 4);
        assertEquals(48, streamNum.reduce(2, (a, b) -> a*b));
    }

    @Test
    void terminalOperatorCollect() {
        //The collect() method is a special type of reduction called a mutable reduction.
        /*
        Method Signature :::::::

        <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)
        <R,A> R collect(Collector<? super T, A,R> collector)
         */

        Stream<String> stream = Stream.of("w", "o", "l", "f");
        StringBuilder collect = stream.collect(StringBuilder::new, (s1, s2) -> s1.append(s2), (s1, s2) -> s1.append(s2));
        System.out.println(collect);
    }

    @Test
    void terminalOperatorCollect_1() {
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        //The supplier creates an empty TreeSet. The
        //accumulator adds a single String from the Stream to the TreeSet. The combiner adds all
        //of the elements of one TreeSet to another in case the operations were done in parallel and
        //need to be merged.
        ArrayList<String> treeSet = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(treeSet);
    }

    @Test
    void terminalOperations_2(){
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        TreeSet<String> collect = stream.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(collect);
    }

    @Test
    void operation() {

        // filter() -> Stream<T> filter(Predicate<? super T> predicate)
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.filter(x -> x.startsWith("m"))
                .forEach(System.out::println);

        //distinct()
        Stream<String> s1 = Stream.of("duck", "duck", "duck", "goose");
        s1.distinct().forEach(System.out::println); //duck goose

        //limit() and skip()
        Stream<Integer> s3 = Stream.iterate(1, n -> n + 1);
        s3.skip(5).limit(2).forEach(System.out::print); //67

        //map() -> <R> Stream<R> map(Function<? super T, ? extends R> mapper)
        Stream<String> s5 = Stream.of("monkey", "gorilla", "bonobo");
        s5.map(data -> data.length()).forEach(System.out::print); //676
    }

    @Test
    void operation_flatmap(){
        //flatMap() -> <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Bonobo");
        List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);
        animals.flatMap(Collection::stream).forEach(System.out::println);
    }

    @Test
    void operation_sorted() {
        //sorted()
        Stream<String> s1 = Stream.of("brown-", "bear-");
        s1.sorted().forEach(System.out::println); // bear-brown-

        Stream<String> s2 = Stream.of("brown-", "bear-");
        s2.sorted(Comparator.reverseOrder()).forEach(System.out::print);
    }

    @Test
    void operation_peek() {
        //peek() -> Stream<T> peek(Consumer<? super T> action)
        Stream<String> stream = Stream.of("black bear", "brown bear", "grizzly");
        long g = stream.filter(s -> s.startsWith("g"))
                .peek(System.out::println) // grizzly
                .count();
        assertEquals(1, g);

        // assign stream values to string builder using peek
        List<Integer> numbers = List.of(1);
        List<Character> characters = List.of('a');
        StringBuilder sb = new StringBuilder();

        Stream<? extends List<? extends Serializable>> listStream = Stream.of(numbers, characters);
        listStream.peek(sb::append).map(List::size).forEach(System.out::print);

        assertEquals("[1][a]", sb.toString());
    }

    @Test
    void operation_chaining() {
        // get the first two names alphabetically that are
        //four characters long

        List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");

        list.stream()
                .filter(s -> s.length() == 4)
                .sorted()
                .limit(2)
                .forEach(s -> System.out.print(s + " ")); //Alex Anna

        Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
        infinite.filter(x -> x % 2 == 1)
                .limit(5)
                .forEach(System.out::println); // 13579
    }

}
