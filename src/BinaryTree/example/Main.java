package BinaryTree.example;

public class Main {

    public static void main(String[] args) {
        // LinkedBinaryTree объект үүсгэх
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();

        // Root нэмэх
        Position<String> root = tree.addRoot("Root");
        System.out.println("Root element : " + root.getElement());

        // Зүүн болон баруун хүүхэд нэмэх
        Position<String> leftChild = tree.addLeft(root, "Left Child");
        Position<String> rightChild = tree.addRight(root, "Right Child");

        // Хүүхдүүдийг хэвлэх
        System.out.println("Left child of root: " + leftChild.getElement());
        System.out.println("Right child of root: " + rightChild.getElement());

        // Left-ийн доор шинэ элемент нэмэх
        Position<String> leftLeft = tree.addLeft(leftChild, "Left-Left");
        System.out.println("Left child of Left Child: " + leftLeft.getElement());

        // Root солих (set ашиглан)
        tree.set(root, "New Root");
        System.out.println("Updated root element: " + root.getElement());

        // Устгах туршилт
        String removed = tree.remove(leftLeft);
        System.out.println("Removed element: " + removed);

        // Модны нийт хэмжээг хэвлэх
        System.out.println("Tree size: " + tree.size());
    }
}
