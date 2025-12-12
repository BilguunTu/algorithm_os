package labTwo.example.progression;

public class FiboProgression extends Progression {

    protected long prev; // Өмнөхөөс өмнөх утга

    // Конструктор: Эхний хоёр утгыг авна
    public FiboProgression(long first, long second) {
        super(first);
        prev = second - first; // prev-ийг зөв тохируулах (prev + first = second)
    }

    // nextValue аргыг хэрэгжүүлэх: current-ийг шинэчилж, prev-ийг урагшлуулна.
    @Override
    protected long nextValue() {
        long answer = current;
        long next = current + prev; // Дараагийн утга
        prev = current; // prev-ийг одоогийн утгаар шинэчилнэ
        current = next; // current-ийг дараагийн утгаар шинэчилнэ
        return answer;
    }
}
