package labFour.example;

public class Node<E> {

    private final E element;

    private Node<E> next;

    public Node(E e, Node<E> n) {
        element = e;
        next = n;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> n) {
        next = n;
    }

}
