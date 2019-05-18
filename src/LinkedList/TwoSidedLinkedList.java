package LinkedList;

public interface TwoSidedLinkedList<E> extends LinkedList<E> {

    void insertLeft(E value);
    void insertRight(E value);

    E removeLeft();

}
