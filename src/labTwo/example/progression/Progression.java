package labTwo.example.progression;

/**
 * Progression дарааллын анхны утга (first) болон одоогийн утга (current) зэрэг
 * үндсэн шинж чанаруудыг агуулсан абстракт класс.
 */
public abstract class Progression {

    // instance variables
    protected long first; // Дарааллын анхны утга
    protected long current; // Дарааллын одоогийн утга

    // Конструктор: Анхны утгыг 0 гэж тохируулна.
    public Progression() {
        this(0);
    }

    // Конструктор: Анхны утгыг өгөгдсөн утгаар тохируулна.
    public Progression(long start) {
        first = start;
        current = start;
    }

    // Дарааллыг хэвлэх нийтлэг арга. n тооны элементийг хэвлэнэ.
    public void printProgression(int n) {
        System.out.print("Дараалал (" + n + "): " + nextValue()); // Эхний утга
        for (int j = 2; j <= n; j++) {
            System.out.print(" " + nextValue()); // Дараагийн утгууд
        }
        System.out.println();
    }

    // Дарааллын дараагийн утгыг тооцоолох (Абстракт арга)
    protected abstract long nextValue();

    // Дарааллыг анхны утгаас эхлүүлэх.
    protected long reset() {
        current = first;
        return current;
    }
}
