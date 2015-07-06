package ch1.ex09;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;


public interface Collection2<E> extends Collection<E> {
    
    /**
     * Performs the given action for each element if the predicate returns true.
     * @param action the action to be performed
     * @param filter the predicate to apply each element
     */
    default void forEachIf(Consumer<? super E> action, Predicate<? super E> filter) {
        Iterator<E> ite = this.iterator();
        while (ite.hasNext()) {
            E elem = ite.next();
            if (filter.test(elem)) {
                action.accept(elem);
            }
        }
    }
}
