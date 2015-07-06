package ch1.ex11;


public class Main {
    public static void main(String[] args) {
        I ins = new Impl();
        ins.f();
        Impl a = new Impl();
        a.f();
    }
}
