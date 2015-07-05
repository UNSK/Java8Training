package ch1.ex6;

import java.util.concurrent.Callable;

public class Unchecker {

    public static void main(String[] args) {
        new Thread(uncheck(() -> {
            System.out.println("Zzz");
            Thread.sleep(1000);
        })).start();
    }

    public static Runnable uncheck(RunnableEx r) {
        return () -> {
            try {
                r.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
    
    @FunctionalInterface
    interface RunnableEx {
        public void run() throws Exception;
    }
    
    public static Callable<Void> uncheck(Callable<Void> c) {
        return () -> {
            try {
                return c.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
 }
