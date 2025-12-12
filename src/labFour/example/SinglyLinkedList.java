package labFour.example;

public class SinglyLinkedList<E> {

    private int size = 0;
    private Node<E> head = null;
    private Node<E> tail = null;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addfirst(E e) {

        head = new Node<>(e, head);

        if (size == 0) {
            tail = head;
        }

        size++;

    }

    public void addlast(E e) {

        Node<E> newest = new Node<>(e, null);

        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }

        tail = newest;

        size++;

    }

    public E removeFirst() {

        if (isEmpty()) {
            return null;
        }

        E answer = head.getElement();

        head = head.getNext();

        size--;

        if (size == 0) {
            tail = null;
        }

        return answer;

    }

    public static void main(String[] args) {

        SinglyLinkedList<String> Sllist = new SinglyLinkedList<String>();

        Node<String> nnode = new Node<String>(null, null);

        Sllist.addfirst("UB");

        Sllist.addlast("ET");

        Sllist.addlast("BU");

        Sllist.addlast("DA");

        System.out.println("Элементийн тоо " + Sllist.size);

        System.out.println("Эхний элемент: " + Sllist.first());

        nnode = Sllist.head.getNext();

        while (!(nnode.getNext() == null)) {

            System.out.println("Дараагийн элемент " + nnode.getElement());

            nnode = nnode.getNext();

        }

        System.out.println("Сүүлийн элемент " + Sllist.last() + "\n");

        int i = 1;

        Sllist.addfirst("EIT");

        while (!(Sllist.isEmpty())) {

            System.out.println(i + " элемент " + Sllist.removeFirst());

            i++;

        }

        System.out.println("Элементийн тоо " + Sllist.size);

    }

    public Node getHead() {
        return head;
    }

}
