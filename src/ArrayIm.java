import java.util.Arrays;
import java.util.Random;

public class ArrayIm <E extends Object & Comparable<? super E>> implements Array<E> {

    static int DEAFAULT_CAPACITY = 8;

    private E[] data;
    private int currentSize;




    public ArrayIm(int capacity) {
        if (capacity>=0) this.data = (E[])(new Object[capacity]);
        else throw new IllegalArgumentException("Емкость не может быть отрицательной");
    }

    public ArrayIm(){
        this(DEAFAULT_CAPACITY);
    }


    @Override
    public void add(E value) {
        checkGrow();
        //O(1)
        data[currentSize++] = value;
    }

    protected void checkGrow() {
        if (isFull(data.length)) {
            growArray();
        }
    }

    private void growArray() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    private boolean isFull(int length) {
        return currentSize == length;
    }

    @Override
    public boolean remove(E value) {
        for (int i=0;i<currentSize-1; i++){
            if (data[i].equals(value)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(int index) {
        for (int i=index; i<currentSize-1; i++){
            data[i]=data[i+1];
        }
        currentSize--;
    }

    @Override
    public E get(int index) {
        return data[index];
    }

    public void set(int index, E value){
        data[index] = value;
    }

    @Override
    public boolean contains(E value) {
        for (int i=0;i<currentSize-1; i++){
            if (data[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(E value) {
        for (int i=0;i<currentSize-1; i++){
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize==0;
    }

    @Override
    public void sortBubble() {
        for (int i=0;i<currentSize-1;i++){
            for (int j = 0; j <currentSize-1-i ; j++) {
                if ((data[j].compareTo(data[j+1]))>0) {
                    change(j,j+1);
                }
            }
        }

    }

    private void change(int first, int second) {
        E tmp = data[first];
        data[first] = data[second];
        data[second] = tmp;
    }

    @Override
    public void sortSelect() {
        for(int i=0 ; i<currentSize-1 ; i++){
            int min=i;
            for (int j=i+1;j<currentSize-1;j++){
                if (data[j].compareTo(data[min])<0){
                    change(j,min);
                }
            }
        }

    }

    @Override
    public void sortInsert() {
        for (int i = 1; i < currentSize; i++) {
            E temp = data[i];

            int in = i;
            while (in > 0 && data[in - 1].compareTo(temp) >= 0) {
                data[in] = data[in - 1];
                in--;
            }

            data[in] = temp;
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<size();i++){
            sb.append(data[i]).append(" ");
        }
        return sb.toString();
    }

}
