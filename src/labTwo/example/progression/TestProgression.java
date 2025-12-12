package labTwo.example.progression;

public class TestProgression {

    public static void main(String[] args) {

        Progression prog; // Progression төрлийн хувьсагч

        System.out.println("--- Арифметик Дараалал (1-ээс эхэлж, 2-оор нэмэгдэнэ) ---");
        // prog нь ArithProgression-ийг заана
        prog = new ArithProgression(1, 2);
        prog.printProgression(10); // Полиморфизм: ArithProgression-ий nextValue ажиллана

        System.out.println("\n--- Геометрийн Дараалал (1-ээс эхэлж, 3-аар үржигдэнэ) ---");
        // prog нь GeomProgression-ийг заана
        prog = new GeomProgression(1, 3);
        prog.printProgression(10); // Полиморфизм: GeomProgression-ий nextValue ажиллана

        System.out.println("\n--- Фибоначчи Дараалал (Эхлэл: 3, 4) ---");
        // prog нь FiboProgression-ийг заана
        prog = new FiboProgression(3, 4);
        prog.printProgression(10); // Полиморфизм: FiboProgression-ий nextValue ажиллана
    }
}
