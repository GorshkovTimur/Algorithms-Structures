package LinkedList;

public class MainList {
    public static void main(String[] args) {
        LinkedList<Integer> linlInt = new LinkedListImple<Integer>();
        linlInt.insert(1);
        linlInt.insert(2);
        linlInt.insert(15);
        linlInt.display();
        linlInt.remove();
        linlInt.display();

        TwoSidedLinkedList<Integer> twoList = new TwoSidedLinkedListImpl<Integer>();
        twoList.insertLeft(1);
        twoList.insertLeft(2);
        twoList.insertRight(3);
        twoList.insertLeft(7);
        twoList.display();


        LinkList list = new LinkList();
        LinkInterator itr = new LinkInterator(list);
        itr.insertBefore("Petya",20);
        itr.insertBefore("Vasys", 18);
        itr.insertAfter("Olesya", 23);
        System.out.println(itr.atEnd());
        list.display();
        itr.reset();
        itr.deleteCurrent();
        System.out.println("------------");
        list.display();

    }
}
