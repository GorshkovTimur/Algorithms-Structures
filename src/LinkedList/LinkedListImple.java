package LinkedList;

public class LinkedListImple<E> implements LinkedList<E> {

    protected Entry<E> firstElement;
    protected int size;


    @Override
    public void insert(E value) {
        Entry<E> newElement = new EntryImpl<>(value);
        newElement.setNext(firstElement);
        firstElement = newElement;
        size++;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        Entry<E> removeElement = firstElement;
        firstElement = firstElement.getNext();
        size--;
        return removeElement.getValue();
    }

    @Override
    public boolean remove(E value) {
        Entry<E> currentElement = firstElement;
        Entry<E> previousElement = null;
        while (currentElement != null) {
            if (currentElement.getValue().equals(value)) {
                break;
            }
            previousElement = currentElement;
            currentElement = currentElement.getNext();
        }
        if (currentElement==null){
            return false;
        }
        if (currentElement==firstElement){
            firstElement = firstElement.getNext();
        }
        else {
            previousElement.setNext(currentElement.getNext());
        }
        size--;
        return true;
    }

    private Entry<E> doFind(E value) {
        Entry<E> currentElement = firstElement;
        while (currentElement != null) {
            if (currentElement.getValue().equals(value)) {
                return currentElement;
            }
            currentElement = currentElement.getNext();

        }
        return null;

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean find(E value) {
        return doFind(value) != null;
    }

    @Override
    public void display() {
        System.out.println("************");
        System.out.println("display" + this.getClass().getSimpleName());
        Entry<E> tmp = firstElement;
        while (tmp!=null){
            System.out.println(tmp);
            tmp = tmp.getNext();
        }

    }

    @Override
    public E getFirst() {
        return firstElement.getValue();
    }
}
