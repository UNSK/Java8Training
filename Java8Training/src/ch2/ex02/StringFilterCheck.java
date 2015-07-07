package ch2.ex02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StringFilterCheck {
    
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./resource/alice.txt");
        String[] ss = Files.lines(path)
            .flatMap(s -> Stream.of(s.split("[\\s,.?!']+")))
            .peek(System.out::println)
            .filter(s -> s.length() > 8)
            .peek(s -> System.out.println("[call filter]"))
            .limit(5)
            .toArray(String[]::new);

        System.out.println();
        Stream.of(ss).forEach(System.out::println);
    }

}
