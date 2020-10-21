package WaitLists;

import java.util.Collection;

public interface IWaitList<E> {
    boolean add(E elem);
    E remove();
    boolean contains(E elem);
    boolean containsAll(Collection<E> elems);
    boolean isEmpty();
}
