package ch2.ex06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFactory {

    public static void main(String[] args) {
        characterStream("Java").forEach(System.out::println);
    }
    
    public static Stream<Character> characterStream(String s) {
        return IntStream.range(0, s.length()).mapToObj(s::charAt);
    }
}
