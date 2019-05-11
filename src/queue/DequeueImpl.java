package queue;

import sun.misc.Queue;

public class DequeueImpl<E> extends QueueImpl<E> implements Dequeue<E> {


    public DequeueImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public void insertLeft(E value) {
        if (!isFull()){
            if (front - 1 <0){
                front=data.length;
            }
            data[--front] = value;
            size++;
        }
        else {
            System.out.println("Dequeue is full");
        }

    }

    @Override
    public void insertRight(E value) {
        super.insert(value);

    }

    @Override
    public E removeLeft() {
        return super.remove();
    }

    @Override
    public E removeRight() {
        if (rear < 0) {
            rear = data.length - 1;
        }
            size--;
            return data[rear--];
        }
    }

