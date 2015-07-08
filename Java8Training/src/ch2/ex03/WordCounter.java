package ch2.ex03;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class WordCounter {
    

    //private static final String PATH = "./resource/warandpeace.txt";
    private static final String PATH = "./resource/alice.txt";


    public static void main(String[] args) throws Exception {
        String contents = new String(Files.readAllBytes(Paths.get(PATH)),
                StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        
        int thresh = 3;
        int trials = 100000;

        long ellapsed = System.nanoTime();
        IntStream.range(0, trials).forEach(i ->
            words.stream().filter(s -> s.length() > thresh).count());
        long sequencialTime = System.nanoTime() - ellapsed;
        
        ellapsed = System.nanoTime();
        IntStream.range(0, trials).forEach(i ->
            words.parallelStream().filter(s -> s.length() > thresh).count());
        long parallelTime = System.nanoTime() - ellapsed;
        
        System.out.println("sequencial: " + sequencialTime);
        System.out.println("parallel  : " + parallelTime);
        
    }
}
