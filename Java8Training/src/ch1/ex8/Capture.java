package ch1.ex8;

import java.util.ArrayList;
import java.util.List;

public class Capture {


    public static void main(String[] args) {
        String[] names = {"Peter", "Paul", "Mary"};
         
        // 順序がバラバラに表示される
        List<Runnable> runners = new ArrayList<>();
        for (String name : names) {
            runners.add(() -> System.out.println(name));
        }
        runners.forEach(r -> new Thread(r).start());
        
        
        // i で回すバージョン
        // ラムダ式の中にはiは使えない
        // 順序は正しく表示される．
        String[] names2 = {"Yamada", "Tanaka", "Suzuki"};
        runners.clear();
        for (int i = 0; i < names2.length; i++) {
            String name = names2[i];
            runners.add(() -> System.out.println(name));
        }
        runners.forEach(r -> new Thread(r).start());
        
    }
}
