package learn.map.withStream;

import java.util.stream.Stream;

public class HowToUseMapInStream {

    //map is method present in the Stream.
    //Intermediate functions filter(),map(), flatMap(),distinct()

    Stream<String> nameStream = Stream.of("Hello","World","Go","Ahead");

    Stream<String> toLowerCaseUsingMap = nameStream.map((String value)-> value.toLowerCase());
    //Used to transform each element


}
