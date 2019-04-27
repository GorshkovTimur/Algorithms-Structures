package queue;


public class Main {

    public static void main(String[] args) {
        Queue<Integer> queueInt = new QueueImpl<>(5);
        Dequeue<Integer> deq = new DequeueImpl<>(5);
        addIfNotFull(queueInt, 1);
        addIfNotFull(queueInt, 2);
        addIfNotFull(queueInt, 3);
        addIfNotFull(queueInt, 4);
        addIfNotFull(queueInt, 15);

        removeIsNotEmpty(queueInt);
        removeIsNotEmpty(queueInt);
        removeIsNotEmpty(queueInt);

        deq.insertLeft(30);
        deq.insertRight(15);
        System.out.println(deq.removeRight());
        System.out.println(deq.removeRight());

        deq.insertLeft(30);
        deq.insertRight(15);

        System.out.println(deq.removeLeft());
        System.out.println(deq.removeLeft());






    }

    private static void addIfNotFull(Queue<Integer> st, Integer value){
        if (!st.isFull()){
            st.insert(value);
        }
    }

    private static void removeIsNotEmpty(Queue<Integer> st){
        if (!st.isEmpty()){
            System.out.println(st.remove());
        }
    }
}
