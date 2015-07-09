package ch2.ex08;

import java.util.Iterator;
import java.util.stream.Stream;

import ch2.ex06.StreamFactory;

public class StreamUtil {
    public static void main(String[] args) {
        
        // ex06を利用
        Stream<Character> s1 = StreamFactory.characterStream("aaaaaaa");
        Stream<Character> s2 = StreamFactory.characterStream("bbbbb");
        
        zip(s1, s2).forEach(System.out::println);
        
    }
    
    /**
     * firstとsecondのストリームの要素を交互に合わせたストリームを作成する。
     * どちらかの要素がなくなれば停止する。
     * @param first a Stream
     * @param second a Stream
     * @return firstとsecondの要素で構成されたストリーム。
     */
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Stream.Builder<T> builder = Stream.builder();
        Iterator<T> i1 = first.iterator();
        Iterator<T> i2 = second.iterator();
        
        boolean f = true;
        while (i1.hasNext() && i2.hasNext()) {
            builder.accept(f ? i1.next() : i2.next());
            f = !f;
        }
        
        return builder.build();
    }
}
