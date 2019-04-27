package LinkedList;

public class LinkList {

        private Link first;


        public LinkList(){
            first = null;

        }

        public Link getFirst() {
            return first;
        }

        public void setFirst(Link first) {
            this.first = first;
        }

        public LinkInterator getIterator(){
            return new LinkInterator(this);
        }

        public boolean isEmpty(){
            return (first == null);
        }

        public void display(){
            Link current = first;
            while(current != null){
                current.display();
                current = current.next;
            }
        }
    }

