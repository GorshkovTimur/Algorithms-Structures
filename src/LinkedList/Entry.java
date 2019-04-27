package LinkedList;

public interface Entry<T> {

    T getValue();

    Entry<T> getNext();

    void setNext (Entry <T> nextElement);
}
