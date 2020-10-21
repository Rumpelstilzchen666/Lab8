package WaitLists;

import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * An unbounded queue based on {@link
 * java.util.concurrent.ConcurrentLinkedQueue}. This queue orders elements FIFO
 * (first-in-first-out).
 *
 * <p>This class implement all of the methods of the {@link WaitLists.IWaitList}
 * interfaces.
 *
 * @param <E> the type of elements held in this queue
 */
public class WaitList<E> implements IWaitList<E> {
    /**
     * A {@code ConcurrentLinkedQueue} that actually stores elements.
     */
    protected ConcurrentLinkedQueue<E> content;

    /**
     * Creates a {@code WaitList} that is initially empty.
     */
    public WaitList() {
        content = new ConcurrentLinkedQueue<>();
    }

    /**
     * Creates a {@code WaitList} initially containing the elements of the given
     * collection, added in traversal order of the collection's iterator.
     *
     * @param elems the collection of elements to initially contain
     */
    public WaitList(final Collection<E> elems) {
        if(elems == null)
            content = new ConcurrentLinkedQueue<>();
        else
            content = new ConcurrentLinkedQueue<>(elems);
    }

    /**
     * Inserts the specified element at the tail of this queue.
     *
     * @param elem the element to be added to the end of the queue
     * @return {@code true} if the specified element is null, otherwise {@code
     * true} (as specified by {@link Queue#offer})
     */
    @Override
    public boolean add(final E elem) {
        if(elem == null)
            return false;
        return content.add(elem);
    }

    /**
     * Retrieves and removes the head of this queue. This implementation returns
     * the result of
     * <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html#poll()">
     * {@code poll}</a>.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @Override
    public E remove() {
        return content.poll();
    }

    /**
     * Returns {@code true} if this queue contains the specified element.
     *
     * @param elem object to be checked for containment in this queue
     * @return {@code true} if this queue contains the specified element
     */
    @Override
    public boolean contains(final E elem) {
        return content.contains(elem);
    }

    /**
     * Returns {@code true} if this queue contains all of the elements in the
     * specified collection.
     *
     * @param elems collection to be checked for containment in this queue
     * @return {@code true} if this queue contains all of the elements in the
     * specified collection
     */
    @Override
    public boolean containsAll(final Collection<E> elems) {
        if(elems == null)
            return true;
        return content.containsAll(elems);
    }

    /**
     * Returns {@code true} if this queue contains no elements.
     *
     * @return {@code true} if this queue contains no elements
     */
    @Override
    public boolean isEmpty() {
        return content.isEmpty();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": content = " + content.toString();
    }
}
