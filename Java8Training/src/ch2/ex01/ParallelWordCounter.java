package ch2.ex01;

import java.util.ArrayList;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelWordCounter {

    private static final String path = "./resource/alice.txt";

    private static int THREAD_NUM = 8;

    public static void main(String[] args) throws Exception {
        String contents = new String(Files.readAllBytes(Paths.get(path)),
                StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        System.out.println(countWord(words));
    }

    private static int countWord(List<String> words) throws Exception {
        ExecutorService executorService = Executors
                .newFixedThreadPool(THREAD_NUM);
        List<Callable<Integer>> tasks = new ArrayList<>();
        int offset = words.size() / THREAD_NUM;
        if (offset < 1) offset = 1;
        for (int i = 0; i < THREAD_NUM; i++) {
            int from = i * offset;
            int to = from + offset;
            if (i == THREAD_NUM - 1) to = words.size(); // TODO リスト分割がいまいちすぎる
            tasks.add(new WordCounter(words.subList(from, to), 8));
        }

        int total = 0;
        try {
            List<Future<Integer>> futures;
            futures = executorService.invokeAll(tasks);

            for (int i = 0; i < THREAD_NUM; i++) {
                total += futures.get(i).get();
            }
        } finally {
            executorService.shutdown();
        }

        return total;
    }

    
}
