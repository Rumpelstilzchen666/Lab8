package WaitLists;

public class UnfairWaitList<E> extends WaitList<E> {
    public UnfairWaitList() {
    }

    public boolean remove(E elem) {
        return content.remove(elem);
    }

    public boolean moveToBack(E elem) {
        if(remove(elem))
            return add(elem);
        return false;
    }
}
