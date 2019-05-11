package tree;

public class TreeImpl<E extends Comparable <? super E>> implements Tree<E> {

    private Node<E> root;




    @Override
    public boolean add(E value) {

        if (root == null){
            root = new Node<>(value);
            return true;
        }

        Node<E> current = root;
        NodeAndPrevious nodeAndPrevious = doFind(value);
        Node<E> previous = nodeAndPrevious.previous;

        if (previous.shouldBeLeft(value)){
            previous.setLeftChild(new Node<>(value));
        }
        else {
            previous.setRightChild(new Node<>(value));
        }

        return true;
    }

    @Override
    public boolean remove(E value) {
        NodeAndPrevious nodeAndPrevious = doFind(value);
        Node<E> removedNode = nodeAndPrevious.current;
        Node<E> parent = nodeAndPrevious.previous;

        if (removedNode == null){
            return false;
        }

        if (removedNode.isLeave()){
            if ( removedNode == root ) {
                root = null;
            }
            else if (parent.getLeftChild() == removedNode){
                parent.setLeftChild(null);
            }
            else {
                parent.setRightChild(null);
            }
        }
        else if (hasOnlySingleChildNode(removedNode)){
            Node<E> childNode = removedNode.getLeftChild() != null
                    ? removedNode.getLeftChild()
                    : removedNode.getRightChild();

            if (removedNode == root ) {
                root = childNode;
            }
            else if (parent.getLeftChild() == childNode){
                parent.setLeftChild(childNode);
            }
            else {
                parent.setRightChild(childNode);
            }
        }

        else {
            Node<E> successor = getSuccessor (removedNode);
            if (removedNode == root ) {
                root = successor;
            }

            else if (parent.getLeftChild() == removedNode) {
                parent.setLeftChild(successor);
            }
            else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(removedNode.getLeftChild());
        }

        return false;
    }

    private Node<E> getSuccessor(Node<E> removedNode) {
        Node<E> successor = removedNode;
        Node<E> successorParent = null;
        Node<E> current = removedNode.getRightChild();
        while ( current !=null ){
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();

        }

        if (successor!=removedNode.getRightChild()){
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removedNode.getRightChild());
        }

        return successor;
    }


    private boolean hasOnlySingleChildNode(Node<E> currentNode) {
        return currentNode.getLeftChild()!=null ^ currentNode.getRightChild() != null;
    }

    @Override
    public boolean find(E value) {
       NodeAndPrevious nodeAndPrevious = doFind(value);
       return nodeAndPrevious.current !=null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void display() {


    }

    @Override
    public void traverse(TraveseMode traverseMode) {
        switch (traverseMode){
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
                default: throw new IllegalArgumentException("Неизвестный TraverseMode");
        }
    }

    private void postOrder(Node<E> node) {


        if (node == null){
            return;
        }

        inOrder(node.getLeftChild());
        inOrder(node.getRightChild());
        System.out.println(node);

    }

    private void preOrder(Node<E> node) {

        if (node == null){
            return;
        }

        System.out.println(node);
        inOrder(node.getLeftChild());
        inOrder(node.getRightChild());
    }


    private void inOrder(Node<E> node) {

        if (node == null){
            return;
        }
        inOrder(node.getLeftChild());
        System.out.println(node);
        inOrder(node.getRightChild());
    }

    private NodeAndPrevious doFind (E value){
        Node<E> current = root;
        Node<E> previous = null;

        while (current!=null){
            if (current.getValue().equals(value)){
                return new NodeAndPrevious(current, previous);
            }

            previous = current;

            if (current.shouldBeLeft(value)){
                current = current.getLeftChild();
            }
            else {
                current = current.getRightChild();
            }
        }
        return new NodeAndPrevious(current, previous);
    }


    class NodeAndPrevious<E extends Comparable<? super E>> {
        Node<E> current;
        Node<E> previous;

        public NodeAndPrevious(Node<E> current, Node<E> previous) {
            this.current = current;
            this.previous = previous;
        }
    }

}
