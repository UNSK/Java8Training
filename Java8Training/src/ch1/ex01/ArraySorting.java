package ch1.ex01;

import java.util.Arrays;

class ArraySorting {

    public static void main(String[] args) {
        String[] strs = { "aaaaa", "ggg", "b", "ffffffffffff" };
        System.out.println("main thread: " + Thread.currentThread());
        Arrays.sort(strs, (first, second) -> {
                System.out.println("comparator thread: " + Thread.currentThread());
                return Integer.compare(first.length(), second.length());
            });
    }

}
