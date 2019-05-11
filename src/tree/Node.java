package tree;

import java.util.Objects;

public class Node<T extends Comparable<? super T>> {

    private final T value;
    private Node<T> leftChild;
    private Node<T> rightChild;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }



    public Node(T value) {
        this.value = value;
    }

    public boolean isLeave(){
        return leftChild == null && rightChild == null;
    }


    public boolean shouldBeLeft (T anotheValue){
        if (anotheValue == null){
            throw new IllegalArgumentException("Не должен быть null");
        }
        return anotheValue.compareTo(value) < 0;
    }




}
