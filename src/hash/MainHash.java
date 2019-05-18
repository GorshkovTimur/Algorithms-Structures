package hash;

public class MainHash {
    public static void main(String[] args) {
        //HashTable hashTable = new HashTableImpl(5);

        //HashTable hashTable = new DoubleHashTableImpl(5);

        HashTable hashTable = new ChainHashTableImpl(5);
        Item orange = new Item("Orange", 1);
        Item banana = new Item("Banana", 77);
        Item lemon = new Item("Lemon", 62);
        Item potato = new Item("Potato", 21);
        Item milk = new Item("Milk", 55);


        hashTable.put(orange, 150);
        hashTable.put(banana, 100);
        hashTable.put(lemon, 250);
        hashTable.put(potato , 67);
        hashTable.put(milk, 120);

        System.out.println(hashTable.get(orange));

        System.out.println(hashTable.getSize());
        hashTable.display();

    }
}
