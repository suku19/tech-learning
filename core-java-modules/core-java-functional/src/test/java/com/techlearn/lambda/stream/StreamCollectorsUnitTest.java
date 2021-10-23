package com.techlearn.lambda.stream;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectorsUnitTest {

    @Test
    void collect_toMap() {

        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map = ohMy.collect(
                Collectors.toMap(s -> s, String::length));
        System.out.println(map); // {lions=5, bears=5, tigers=6}

        // length of the animal name to the name itself
        Stream<String> ohMy1 = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map1 = ohMy1.collect(Collectors.toMap(
                String::length, k -> k, (s1, s2) -> s1 + "," + s2));
        System.out.println(map1); // {5=lions,bears, 6=tigers}
        System.out.println(map1.getClass()); // class. java.util.HashMap

        // get the result in tree map
        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map2 = ohMy2.collect(Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2, TreeMap::new));
        System.out.println(map2.getClass()); // class. java.util.TreeMap
    }

    @Test
    void collector_groupByList() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> collect = ohMy.collect(Collectors.groupingBy(String::length));
        System.out.println(collect);
    }

    @Test
    void collector_groupBySet() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Set<String>> collect = ohMy.collect(Collectors.groupingBy(String::length, Collectors.toCollection(TreeSet::new)));
        System.out.println(collect);
    }

    @Test
    void collector_groupBySetIntoTreeMap() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Set<String>> collect = ohMy.collect(Collectors.groupingBy(String::length,TreeMap::new, Collectors.toCollection(TreeSet::new)));
        System.out.println(collect.getClass());
    }

    @Test
    void collector_partitionBy() {
        //With partitioning, there are only two possible
        //groups—true and false. Partitioning is like splitting a list into two parts.
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");

        Predicate<String> sizeLessThanFive = s -> s.length() <= 5;
        Map<Boolean, List<String>> collect = ohMy.collect(Collectors.partitioningBy(sizeLessThanFive));// one with predicate true and other is false
        System.out.println(collect);
    }

    @Test
    void collectors_mapping() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Optional<Character>> map = ohMy.collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(s -> s.charAt(0),
                                Collectors.minBy(Comparator.naturalOrder()))));
        System.out.println(map); // {5=Optional[b], 6=Optional[t]}

    }
}
