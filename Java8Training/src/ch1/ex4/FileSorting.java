package ch1.ex4;

import java.io.File;
import java.util.Arrays;

public class FileSorting {
    public static void main(String[] args) {
        File[] files = new File(".").listFiles();
        
        Arrays.sort(files, (f1, f2) -> {
            boolean a = f1.isDirectory();
            boolean b = f2.isDirectory();
            if (a ^ b) {
                return a ? -1 : 1;
            } else {
                return f1.getPath().compareTo(f2.getPath());
            }
        });
        
        Arrays.stream(files).forEach(System.out::println);
    }
}
