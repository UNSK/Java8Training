package ch1.ex10;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

/**
 * JUnit test case for ch1.ex10
 */
public class CollectionExTest {

    @Test
    public void maxTest() {
        ListEx<Integer> list = new ArrayListEx<>();
        
        list.add(10);
        list.add(1000);
        list.add(100);
        list.add(1);
        
        assertThat(list.max(Integer::compare), is(1000));
    }

    @Test
    public void disjointTest() {
        ListEx<Integer> list1 = new ArrayListEx<>();
        ListEx<Integer> list2 = new ArrayListEx<>();
        
        list1.add(1);
        list2.add(2);
        
        assertTrue(CollectionEx.disjoint(list1, list2));
        
        list2.add(1);
        
        assertFalse(CollectionEx.disjoint(list1, list2));
    }
}
