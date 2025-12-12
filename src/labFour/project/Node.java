package labFour.project;

public class Node {

    GameEntry element; // Тухайн элементийн өгөгдөл (GameEntry)
    Node next;         // Жагсаалтын дараагийн элемент рүү заах заагч

    public Node(GameEntry e, Node n) {
        element = e;
        next = n;
    }

    public GameEntry getElement() {
        return element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node n) {
        next = n;
    }
}
