import java.util.Random;

public class Main {


    public static void main(String[] args) {
        ArrayIm<Integer> arr1 = new ArrayIm<>();
        ArrayIm<Integer> arr2 = new ArrayIm<>();
        ArrayIm<Integer> arr3 = new ArrayIm<>();

        fillRandom(arr1);
        fillRandom(arr2);
        fillRandom(arr3);

        long start = System.currentTimeMillis();
        arr1.sortBubble();
        long finish = System.currentTimeMillis();
        System.out.println(finish-start);
        start = System.currentTimeMillis();
        arr2.sortInsert();
        finish = System.currentTimeMillis();
        System.out.println(finish-start);
        start = System.currentTimeMillis();
        arr3.sortSelect();
        finish = System.currentTimeMillis();
        System.out.println(finish-start);


//        arr.add(1);
//        arr.add(2);
//        arr.add(15);
//        System.out.println(arr);
//        arr.remove(2);
//        System.out.println(arr);
//        System.out.println(arr.contains(15));

    }

    private static void fillRandom(ArrayIm<Integer> arr1) {
        Random rnd = new Random();
        for (int i=0;i<100000;i++){
            arr1.add(rnd.nextInt());
        }
    }
}
