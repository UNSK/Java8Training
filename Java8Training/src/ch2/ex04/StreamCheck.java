package ch2.ex04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCheck {
    public static void main(String[] args) {
        int[] value = {1, 4, 9, 16};
        
        // int[]のストリームになる
        Stream<int[]> stream = Stream.of(value);
        stream.forEach(System.out::println);
        
        // intのストリームを得るにはIntSteam.of()をつかう
        IntStream intStream = IntStream.of(value);
        intStream.forEach(System.out::println);
    }
}
