package learn.map.withStream;


/*
*

You are given a list of integers. Write a Java method that uses Streams to find the first three
* distinct even numbers from the list,
* squared, and
* sorted in ascending order.
* If there are fewer than three distinct
*  even numbers,
* return as many as are available. Provide a complete code example demonstrating this.
*
*
*
*
*
*
* */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class GoogleStreamQ {

    public void solution() {

        List<Integer> listOfInteger = Arrays.asList(1,2,3,2,4,7,5,9,79,10,12);

//        Stream<Integer> listOfStream = listOfInteger.stream();

        listOfInteger.stream().filter((Integer v)->v%2==0)
                .map((Integer i)->i*i)
                .sorted()
                .distinct()
                .limit(3)
                .skip(1)
                .forEach(System.out::println);

    }
}
