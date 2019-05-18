package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    static final int MAX_LEVEL = 4;
    static final int MIN = -20;
    static final int MAX = 20;

    public static void main(String[] args) {
//
//        TreeImpl<Integer> tree = new TreeImpl<>(5);
//        tree.add(10);
//        tree.add(5);
//        tree.add(22);
//        tree.add(60);
//
//        tree.display();
//        System.out.println(tree.calcHeight(5));
//        System.out.println(tree.calcHeight(10));
//        System.out.println(tree.calcHeight(22));
//        System.out.println(tree.calcHeight(60));
//        System.out.println(tree.isBalanced(10));
//        tree.add(61);
//        tree.add(68);
//        tree.add(70);
//        tree.add(75);
//        System.out.println(tree.isBalanced(10));

        Random rnd = new Random();
        final int diff = MAX - MIN;


        List<TreeImpl> list = new ArrayList<>();

        for (int i=0 ; i < 10 ; i++){
            list.add(new TreeImpl(MAX_LEVEL+1));
        }


        for (TreeImpl tree:list) {
            do {
                int k = rnd.nextInt(diff + 1);
                k += MIN;
                tree.add(k);
            }  while (tree.calcHeight(tree.getRoot().getValue()) < MAX_LEVEL);
            tree.display();
            System.out.println();
            System.out.println(tree.isBalanced(tree.getRoot().getValue()));
        }


    }
}
