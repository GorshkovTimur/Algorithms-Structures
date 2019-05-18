package recursive;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       Exponentation exp = new Exponentation(5);
        System.out.println(exp.getExponentation(5));

        List<Item> items = new ArrayList<>();
        items.add(new Item("Книга", 1, 600));
        items.add(new Item("Бинокль", 2, 5000));
        items.add(new Item("Аптечка", 4, 1500));
        items.add(new Item("Ноутбук", 2, 40000));
        items.add(new Item("Котелок", 1, 500));

        Backpack bp = new Backpack(5);
        bp.calcBestSet(items);

        items = bp.getBestItems();

        for (int i=0 ; i < items.size(); i++){
            System.out.println(items.get(i).getName() + " " + items.get(i).getPrice() + "\n");
        }


    }
}
