package hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ChainHashTableImpl implements HashTable {

    private class Entry {
        private Item key;
        private int value;

        public Entry(Item key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
    private int size;
    private int maxSize;
    private LinkedList<Entry>[] data;

    public ChainHashTableImpl(int maxSize) {
        this.data = new LinkedList[maxSize];
        this.maxSize = maxSize;
    }

    @Override
    public boolean put(Item item, Integer cost) {
        int index = hashFunc(item.hashCode());
        if (data[index] == null){
            data[index] = new LinkedList<Entry>();
            data[index].add(new Entry(item,cost));
            size++;
        }
        else {
            data[index].add(new Entry(item,cost));
        }
        return true;
    }

    @Override
    public Integer get(Item item) {
        if (indexOf(item) !=-1){
            LinkedList<Entry> list = data[indexOf(item)];
            for (int i=0; i<list.size();i++) {
                if (list.get(i).key.equals(item)){
                    return list.get(i).value;
                }
            }
        }
        return null;
    }

    @Override
    public boolean remove(Item item) {
        if (indexOf(item) !=-1){
            LinkedList<Entry> list = data[indexOf(item)];
            for (Entry entry:list) {
                if (entry.key.equals(item)){
                    list.remove(entry);
                    if (list.isEmpty()){
                        size--;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        for (int i = 0; i < data.length; i++) {
            if (data[i]!=null)
            System.out.println(data[i].toString());
        }

    }

    private int hashFunc(int key){
        return key % data.length;
    }

    private int indexOf (Item item){
        int index = hashFunc(item.hashCode());
        LinkedList<Entry> list = data[index];
        if (list.isEmpty()){
            return -1;
        }
        if (list.contains(item)){
            return index;
        }
        return -1;
    }
}
