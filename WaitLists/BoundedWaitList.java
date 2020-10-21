package WaitLists;

public class BoundedWaitList<E> extends WaitList<E> {
    private final int capacity;

    public BoundedWaitList(final int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean add(E elem) {
        if(content.size() < capacity)
            return super.add(elem);
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ", capacity = " + capacity;
    }
}
