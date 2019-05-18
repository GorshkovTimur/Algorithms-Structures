package stack;

import java.util.Arrays;

public class StackImpl<E> implements Stack<E>{

    private static int DEAFAULT_SIZE = 8;
    private E[] data;
    private int size;


    public StackImpl(int capacity){
        this.data = (E[]) new Object[capacity];
    }

    public StackImpl(){
        this(DEAFAULT_SIZE);
    }


    @Override
    public void push(E value) {
        data[size++]=value;
    }

    @Override
    public E peek() {
        return data[size-1];
    }

    @Override
    public E pop() {
        return data[--size];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return data.length==size;
    }

    @Override
    public int getSize() {
        return size;
    }

}
