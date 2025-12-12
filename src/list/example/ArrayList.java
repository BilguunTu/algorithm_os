package list.example;

public class ArrayList<E> implements List<E> {

    public static final int CAPACITY = 16;  // анхдагч массив багтаамж

    private E[] data; // Queue-гийн элемент хадгалахад ашигладаг ерөнхий массив

    private int size = 0;  // одоогийн элементийн тоо

    public ArrayList() {
        this(CAPACITY);
    } // өөрийн багтаамж бүхий жагсаалтыг бүтээдэг

    public ArrayList(int capacity) { // өгөгдсөн багтаамж бүхий жагсаалтыг байгуулна

        data = (E[]) new Object[capacity]; // төрөл хувиргагч; хөрвүүлэгч анхааруулга өгч болно

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
