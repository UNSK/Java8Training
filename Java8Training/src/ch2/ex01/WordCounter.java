package ch2.ex01;

import java.util.List;
import java.util.concurrent.Callable;

public class WordCounter implements Callable<Integer> {

    private final List<String> words;
    private final int threashold;

    public WordCounter(List<String> words, int threshold) {
        this.words = words;
        this.threashold = threshold;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        for (String s : words) {
            System.out.println(s);
            if (s.length() > threashold) {
                count++;
            }
        }
        return count;
    }
}
