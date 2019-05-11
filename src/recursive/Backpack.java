package recursive;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private final int maxWeight;
    private int bestPrice;

    public List<Item> getBestItems() {
        return bestItems;
    }

    private List<Item> bestItems;


    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    private int calcWeight (List<Item> items) {
        int sumWeight = 0;
        for (Item item : items){
            sumWeight+=item.getWeight();
        }
        return sumWeight;
    }

    private int calcPrice (List<Item> items) {
        int sumPrice = 0;
        for (Item item : items){
            sumPrice += item.getPrice();
        }
        return sumPrice;
    }

    private void bestSet (List<Item> items){
        if (bestItems == null){
            if (calcWeight(items) <= maxWeight){
                bestItems = items;
                bestPrice = calcPrice(items);
            }
        } else {
            if (calcWeight(items)<=maxWeight && calcPrice(items)> bestPrice){
                bestItems = items;
                bestPrice = calcPrice(items);
            }
        }
    }

    public void calcBestSet (List<Item> items){
        if (items.size() > 0) {
            bestSet(items);
        }

        for (int i = 0 ; i < items.size() ; i++){
            List<Item> list = new ArrayList<>(items);
            list.remove(i);
            calcBestSet(list);
        }

    }


}
