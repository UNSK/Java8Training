package ch2.ex09;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamUtil {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("Java");
        Stream<ArrayList<String>> stream = Stream.of(list, list, list);
        concatToList(stream).forEach(System.out::println);
    }
    
    /**
     * ArrayListのストリームをArrayListにリダクションする。
     * @param stream ArrayListのストリーム。
     * @return 各ArrayListを連結したArrayList。
     */
    public static <T> ArrayList<T> concatToList(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList<>(), (i, e) -> {
            i.addAll(e); 
            return i;
            });
    }
}
