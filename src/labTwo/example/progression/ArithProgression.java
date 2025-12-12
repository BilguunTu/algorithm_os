package labTwo.example.progression;

public class ArithProgression extends Progression {

    protected long increment; // ялгавар

    public ArithProgression(long start, long step) {
        super(start);
        increment = step;
    }

    public ArithProgression(long step) {
        this(0, step);
    }

    // nextValue аргыг хэрэгжүүлэх: current утга дээр increment-ийг нэмнэ.
    @Override
    protected long nextValue() {
        long answer = current;
        current += increment;
        return answer;
    }
}
