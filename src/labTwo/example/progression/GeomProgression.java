package labTwo.example.progression;

public class GeomProgression extends Progression {

    protected long base; // Үржүүлэгч (үржвэр)

    public GeomProgression(long start, long b) {
        super(start);
        base = b;
    }

    public GeomProgression(long b) {
        this(1, b); // Геометрийн дараалал ихэвчлэн 1-ээс эхэлдэг
    }

    // nextValue аргыг хэрэгжүүлэх: current утгыг base-ээр үржүүлнэ.
    @Override
    protected long nextValue() {
        long answer = current;
        current *= base;
        return answer;
    }
}
