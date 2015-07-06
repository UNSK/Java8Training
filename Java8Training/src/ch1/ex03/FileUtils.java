package ch1.ex03;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class FileUtils {
    
    public static void main(String[] args) {
        getAllFiles(new File("./src/ch1/ex3"), ".java").forEach(System.out::println);
    }
    
    /**
     * Gets all files that have the given extension.
     * @param parent the parent directory.
     * @param ext A extension String. Starts with '.'
     * @return list of files.
     * @throws IllegalArgumentException if parent is not directory or ext does not start with '.'
     */
    public static List<File> getAllFiles(File parent, String ext) {
        if (!parent.isDirectory()) {
            throw new IllegalArgumentException("not directory");
        }
        if (!ext.startsWith(".")) {
            throw new IllegalArgumentException("ext must start with '.'");
        }
        
        // ext がエンクロージング環境からキャプチャされる．
        String[] filenames = parent.list((dir, name) -> name.endsWith(ext));
        List<File> files = new ArrayList<>();
        
        for (String s : filenames) {
            files.add(new File(s));
        }
        
        return files;
    }
}
