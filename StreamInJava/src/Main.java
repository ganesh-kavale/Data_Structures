import learn.map.withStream.ALLCollectorsMethodFromStream;
import learn.map.withStream.GoogleStreamQ;
import learn.map.withStream.GoogleStreamQ2;
import learn.map.withStream.MapUseForStreamConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");


        //map is method present in the Stream.
        //Intermediate functions filter(),map(), flatMap(),distinct()

        Stream<String> nameStream = Stream.of("Hello","World","Go","Ahead");

        Stream<String> toLowerCaseUsingMap = nameStream.map((String value)-> value.toLowerCase());
        //Used to transform each element

        toLowerCaseUsingMap.forEach((String value)->System.out.println(value));


//Output
//        hello
//                world
//        go
//                ahead

        List<String> list1 = Arrays.asList("I","AM","Ok");
        List<String> list2 = Arrays.asList("Where", "are","you");
        List<String> list3 = Arrays.asList("ahead","go,","Going");

        List<List<String>> listOfListData = Arrays.asList(list1,list2,list3);

        //way1 concept create pipeline (Stream) one after other
        Stream <List<String>> listSteam2 = listOfListData.stream();

       Stream<String> l= listSteam2.flatMap((List<String> value)-> value.stream());

        Stream<String> streamPrint = l.filter((String v)-> v.length()>=1);

        System.out.println("Check1: ");

        streamPrint.forEach(System.out::println);
//Output :  I
       //Way2
        Stream <List<String>> listSteam1 = listOfListData.stream();

        listSteam1.flatMap((List<String> value)-> value.stream().filter((String value1)->value1.length()<=1))
                .forEach((String vv)->System.out.println("element:" + vv));
//Output :  I
        //Way3
        Stream <List<String>> listSteam = listOfListData.stream();

        listSteam.flatMap((List<String> value)-> value.stream().filter((String value1)->value1.length()<=1))
                .forEach(System.out::println);
//Output :  I
        //Way4
        Stream <List<String>> listSteam4 = listOfListData.stream();

        Stream<String> forPrint = listSteam4.flatMap((List<String> v2)-> v2.stream().filter((String v1)->v1.length()==1));

        forPrint.forEach(System.out::println);
        System.out.println("jhgggggggggggg" +listSteam.hashCode());

        //Output :  I

        //Q1
        GoogleStreamQ g =new GoogleStreamQ();

        System.out.println("Solution google question:  ");

        g.solution();

//        Output:
//        Solution google question:
//        16
//        100

        //Q2
        GoogleStreamQ2 g2 =new GoogleStreamQ2();

        System.out.println("Solution google question2:  ");

        g2.solution();

//Output

//        Solution google question2:
//        T3,4587
//        T5,2450
//        T2,789

        MapUseForStreamConcept map = new MapUseForStreamConcept();

        map.solution();


        ALLCollectorsMethodFromStream c = new ALLCollectorsMethodFromStream();

        c.CollectorsMethod();

        FindDuplicatesUseMap f = new FindDuplicatesUseMap();

        List<Integer> n = Arrays.asList(1,54,5,4,1,1,1,54,1);

        f.solution(n);
        f.solutionUsingStream(n);

        f.solutionLongestSubstring("abcdaabbsdfe");

    }
}
/*
        // Create three lists of strings using new ArrayList<>
        List<String> list1 = new ArrayList<>();
        list1.add("I");
        list1.add("AM");
        list1.add("Ok");

        List<String> list2 = new ArrayList<>();
        list2.add("Where");
        list2.add("are");
        list2.add("you");

        List<String> list3 = new ArrayList<>();
        list3.add("ahead");
        list3.add("go,");
        list3.add("Going");

        // Combine the lists into a list of lists
        List<List<String>> listOfListData = new ArrayList<>();
        listOfListData.add(list1);
        listOfListData.add(list2);
        listOfListData.add(list3); */

/*
        List<String> filteredList = list.stream()
                .filter(str -> str.length() > 3)
                .collect(Collectors.toList());

        List<String> upperCaseList = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        List<String> flatList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());


        List<String> flatList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        List<Integer> distinctList = list.stream()
                .distinct()
                .collect(Collectors.toList());

        List<String> sortedList = list.stream()
                .sorted()
                .collect(Collectors.toList());

        List<String> customSortedList = list.stream()
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());


        List<String> limitedList = list.stream()
                .limit(3)
                .collect(Collectors.toList());


        List<String> peekedList = list.stream()
                .peek(System.out::println)
                .collect(Collectors.toList());



        import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

        public class Main {
            public static void main(String[] args) {
                List<String> list = new ArrayList<>();
                list.add("apple");
                list.add("banana");
                list.add("orange");
                list.add("banana");
                list.add("grape");

                // Intermediate operations: filter, distinct, sorted, map
                List<String> result = list.stream()
                        .filter(str -> str.length() > 5)   // Filter strings with length > 5
                        .distinct()                        // Remove duplicates
                        .sorted()                          // Sort alphabetically
                        .map(String::toUpperCase)          // Convert to uppercase
                        .collect(Collectors.toList());     // Collect the result

                // Print the result
                result.forEach(System.out::println);
            }
        }

        */


/*
*
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamCreationExamples {
    public static void main(String[] args) {
        // 1. From a Collection
        List<String> list = Arrays.asList("apple", "banana", "orange");
        Stream<String> streamFromList = list.stream();
        System.out.println("Stream from list:");
        streamFromList.forEach(System.out::println);

        // 2. From an Array
        String[] array = {"apple", "banana", "orange"};
        Stream<String> streamFromArray = Arrays.stream(array);
        System.out.println("\nStream from array:");
        streamFromArray.forEach(System.out::println);

        // 3. From Stream.of()
        Stream<String> streamFromValues = Stream.of("apple", "banana", "orange");
        System.out.println("\nStream from Stream.of():");
        streamFromValues.forEach(System.out::println);

        // 4. From a File (File must exist; replace "file.txt" with a real file path)
        try (Stream<String> streamFromFile = Files.lines(Paths.get("file.txt"))) {
            System.out.println("\nStream from file:");
            streamFromFile.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("\nError reading file: " + e.getMessage());
        }

        // 5. From a Range (Primitive type stream)
        IntStream intStream = IntStream.range(1, 10); // Range is [1, 10)
        System.out.println("\nIntStream from range:");
        intStream.forEach(System.out::println);

        // 6. From Generate (Infinite stream)
        Stream<String> infiniteStream = Stream.generate(() -> "element");
        System.out.println("\nStream from generate (limited to 5 elements):");
        infiniteStream.limit(5).forEach(System.out::println);

        // 7. From Iterate (Infinite stream)
        Stream<Integer> iterateStream = Stream.iterate(1, n -> n + 1);
        System.out.println("\nStream from iterate (limited to 5 elements):");
        iterateStream.limit(5).forEach(System.out::println);
    }
}

*
* */