package queue;

public class QueueImpl<E> implements Queue<E> {

    public static final int DEFAULT_FRONT = 0;
    public static final int DEFAULT_REAR = -1;


    protected E[] data;
    protected int size;
    protected int front;
    protected int rear;


    public QueueImpl(int maxSize) {
        this.data = (E[])new Object[maxSize];
        front= DEFAULT_FRONT;
        rear = DEFAULT_REAR;
    }

    @Override
    public void insert(E value) {
        if (rear==data.length-1){
            rear=DEFAULT_REAR;
        }
        data[++rear]=value;
        size++;

    }

    @Override
    public E remove() {
        if (front==data.length){
            front=DEFAULT_FRONT;
        }
        E value = data[front++];
        size--;
        return value;
    }

    @Override
    public E peek() {
        return data[front];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size==data.length;
    }

    @Override
    public int getSize() {
        return size;
    }

}
