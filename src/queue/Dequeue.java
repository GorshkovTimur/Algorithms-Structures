package queue;

public interface Dequeue<E> extends Queue<E> {

    void insertLeft (E value);
    void insertRight(E value);

    E removeLeft();
    E removeRight();


}
