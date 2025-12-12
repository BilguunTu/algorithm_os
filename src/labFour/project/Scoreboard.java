package labFour.project;

//Хамгийн өндөр эхний 10 оноог нэг холбосон жагсаалт ашиглан хадгалах класс.
public class Scoreboard {

    private int numEntries = 0; // Жагсаалт дахь элементийн тоо
    private Node head = null;    // Жагсаалтын эхний элемент рүү заах заагч (head)
    private int capacity;       // Хүчин чадал (жишээлбэл, 10)

    public Scoreboard(int capacity) {
        this.capacity = capacity;
    }

    public void add(GameEntry entry) {
        int newScore = entry.getScore();

        // 1. Оноо нь хамгийн бага онооноос бага эсвэл хүчин чадал дүүрсэн үед
        if (numEntries == capacity) {
            if (head == null || newScore <= head.getElement().getScore()) {
                return; // Нэмэх шаардлагагүй
            }
        }

        // 2. Жагсаалтад оруулах байрлалыг олох (оноо буурах дарааллаар)
        Node newNode = new Node(entry, null);

        // a) Хоосон жагсаалт эсвэл шинэ оноо нь хамгийн өндөр байх үед (эхэнд нэмэх)
        if (head == null || newScore > head.getElement().getScore()) {
            newNode.setNext(head);
            head = newNode;
        } else {
            // b) Дунд эсвэл сүүлд нэмэх
            Node current = head;
            Node previous = null;

            // Шинэ онооноос бага оноотой элементийг олох хүртэл явна.
            while (current != null && current.getElement().getScore() >= newScore) {
                previous = current;
                current = current.getNext();
            }

            // Шинэ элементийг нэмэх
            newNode.setNext(current);
            previous.setNext(newNode);
        }

        numEntries++;

        // 3. Хэрэв хүчин чадлаас хэтэрсэн бол хамгийн сүүлийн (хамгийн бага оноотой) элементийг хасна.
        if (numEntries > capacity) {
            remove(numEntries - 1); // Сүүлийн элементийг хасна
        }
    }

    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= numEntries) {
            throw new IndexOutOfBoundsException("Хүчингүй индекс: " + i);
        }

        GameEntry removedEntry;

        // 1. Эхний элементийг хасах (i=0)
        if (i == 0) {
            removedEntry = head.getElement();
            head = head.getNext(); // Head-ийг дараагийн элемент рүү шилжүүлнэ
        } else {
            // 2. Бусад элементийг хасах (i > 0)
            Node current = head;
            // i-1-р элемент дээр зогсох хүртэл явна.
            for (int k = 0; k < i - 1; k++) {
                current = current.getNext();
            }

            Node nodeToRemove = current.getNext();
            removedEntry = nodeToRemove.getElement();

            // Заагчийг өөрчлөх: current -> (хасагдах элемент) -> current.next.next
            current.setNext(nodeToRemove.getNext());
        }

        numEntries--;
        return removedEntry;
    }

    // Жагсаалтын агуулгыг хэвлэх туслах функц
    public void printScores() {
        Node current = head;
        System.out.println("--- Онооны самбар (Топ " + capacity + ") ---");
        int rank = 1;
        while (current != null) {
            System.out.println(rank++ + ". " + current.getElement().toString());
            current = current.getNext();
        }
        System.out.println("--- Хэрэгжүүлсэн: " + numEntries + " ---");
    }
}
