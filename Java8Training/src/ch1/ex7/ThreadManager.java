package ch1.ex7;

public class ThreadManager {

    public static void main(String[] args) throws Exception {
        new Thread(andThen(() -> {
                try {
                    System.out.println("first thread");
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // ignore
                }
            }, 
            () -> {
                try {
                    System.out.println("second thread");
                } catch (Exception e) {
                    // ignore
                }
            })).start();
    }

    public static Runnable andThen(Runnable r1, Runnable r2) {
        try {
            Thread t = new Thread(r1);
            t.start();
            t.join();
            return r2;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
