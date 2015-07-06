package ch1.ex02;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class FileUtils {

    public static void main(String[] args) {
        getAllSubDirectories(new File(".")).forEach(System.out::println);
        System.out.println("---------------------");
        getAllSubDirectories2(new File(".")).forEach(System.out::println);
    }
    
    /**
     * Gets all sub directories.
     * @param parent the parent directory
     * @return list of all sub directories paths.
     * @throws IllegalArgumentException if parent is not directory.
     */
    private static List<File> getAllSubDirectories(File parent) {
        if (!parent.isDirectory()) {
            throw new IllegalArgumentException("not directory");
        }
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
     * @throws IllegalArgumentException if parent is not directory.
     */
    private static List<File> getAllSubDirectories2(File parent) {
        if (!parent.isDirectory()) {
            throw new IllegalArgumentException("not directory");
        }
        File[] directories = parent.listFiles(File::isDirectory);
        List<File> list = new ArrayList<>();
        list.add(parent);
        for (File f : directories) {
            list.addAll(getAllSubDirectories(f));
        }
        return list;
    }
}
