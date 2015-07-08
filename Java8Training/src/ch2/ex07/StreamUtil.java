package ch2.ex07;

import java.util.stream.Stream;

public class StreamUtil {

    public static void main(String[] args) {
        Stream<Integer> infiniteStream = Stream.iterate(0, i -> i++);
        System.out.println(isFinite(infiniteStream));
        
        Stream<Integer> finiteStream = Stream.of(1,2,3,4,5);
        System.out.println(isFinite(finiteStream));
        
        // terminal operator を実行してしまっているのでIllegalStateException
        // infiniteStream.filter(n -> n % 3 == 0).limit(3);
    }
    
    public static <T> boolean isFinite(Stream<T> stream) {
        // spliterator() は terminal operation
        return stream.spliterator().estimateSize() != Long.MAX_VALUE; 
    }
}
