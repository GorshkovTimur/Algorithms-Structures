package stack;

public interface Stack<E> {

    void push(E value);

    E peek();

    E pop();

    boolean isEmpty();
    boolean isFull();

    int getSize();

}
