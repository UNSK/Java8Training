package ch1.ex2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryUtils {

    public static void main(String[] args) {
        getAllSubDirectories(new File(".")).forEach(System.out::println);
        System.out.println("---------------------");
        getAllSubDirectories2(new File(".")).forEach(System.out::println);
    }
    
    /**
     * Gets all sub directories.
     * @param parent the parent directory
     * @return list of all sub directories paths.
     */
    private static List<File> getAllSubDirectories(File parent) {
        File[] directories = parent.listFiles(f -> f.isDirectory());
        List<File> list = new ArrayList<>();
        list.add(parent);
        for (File f : directories) {
            list.addAll(getAllSubDirectories(f));
        }
        return list;
    }
    
    /**
     * Gets all sub directories.
     * @param parent the parent directory
     * @return list of all sub directories paths.
     */
    private static List<File> getAllSubDirectories2(File parent) {
        File[] directories = parent.listFiles(File::isDirectory);
        List<File> list = new ArrayList<>();
        list.add(parent);
        for (File f : directories) {
            list.addAll(getAllSubDirectories(f));
        }
        return list;
    }
}
