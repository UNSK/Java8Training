package ch1.ex9;

import static org.junit.Assert.*;

import org.junit.Test;

import ch1.ex09.ArrayList2;
import ch1.ex09.List2;

/**
 * JUnit test case for ch1.ex9
 */
public class Collection2Test {

    @Test
    public void forEachIfTest() {
        List2<Integer> list = new ArrayList2<>();
        
        list.add(1);
        list.add(2);
        list.add(-2);
        list.add(3);
        list.add(-99);
        list.add(4);
        
        list.forEachIf(System.out::println, (x) -> x > 0);
        
        List2<Integer> list2 = new ArrayList2<>();
        list.forEachIf(list2::add, x -> x > 0);
        
        for (int a : list2) {
            assertTrue(a > 0);
        }
    }

}
