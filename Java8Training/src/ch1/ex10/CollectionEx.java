package ch1.ex10;


import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


/**
 * インスタンスを引数にとるものはdefaultで提供する
 * インスタンスを引数に取らないものはstaticで実装する
 */
public interface CollectionEx<E> extends Collection<E> {


    /**
     * default implementation of 
     * Collections.max(Collection<? extends T> coll, Comparator<? super T> comp).
     * @param comp the Comparator
     * @return the max value in this collection
     */
    default E max(Comparator<? super E> comp) {
        return this.stream().max(comp).get();
    }
    
    /**
     * implementation in static way of 
     * Collection.disjoint(Collection<?> c1, Collection<?> c2).
     * @param c1 a collection
     * @param c2 a collection
     * @return true if the two collections have no elements in common.
     */
    static boolean disjoint(Collection<?> c1, Collection<?> c2) {
        return Collections.disjoint(c1, c2);
    }
}
