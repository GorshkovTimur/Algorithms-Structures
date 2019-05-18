package hash;

public class MainHash {
    public static void main(String[] args) {
       // HashTable hashTable = new HashTableImpl(5);

        HashTable hashTable = new DoubleHashTableImpl(5);

        hashTable.put(new Item("Orange", 1), 150);
        hashTable.put(new Item("Banana", 77), 100);
        hashTable.put(new Item("Lemon", 62), 250);
        hashTable.put(new Item("Potato", 21), 67);
        hashTable.put(new Item("Milk", 55), 120);

        System.out.println(hashTable.getSize());
        hashTable.display();

    }
}
