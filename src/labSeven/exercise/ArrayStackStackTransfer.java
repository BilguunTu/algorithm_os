package labSeven.exercise;

import java.util.Stack;

public class ArrayStackStackTransfer {

    public static <E> void transfer(Stack<E> S, Stack<E> T) {

        while (!S.isEmpty()) {

            // 1. S-ийн оройн элементийг гаргаж авна.
            E element = S.pop();

            // 2. Гаргаж авсан элементийг шууд T-ийн оройд оруулна.
            T.push(element);

            // Энэ нь S-ийн орой байсан элементүүд T-ийн доод тал руу явж,
            // S-ийн доод тал байсан элементүүд T-ийн орой руу гарч ирнэ.
        }
    }

    public static void main(String[] args) {
        // Жишээ Стекийг үүсгэх (Эхний орой нь 3)
        Stack<Integer> stackS = new Stack<>();
        stackS.push(1);
        stackS.push(2);
        stackS.push(3);
        // S: [1 (доод), 2, 3 (орой)]

        // Очих ёстой стек
        Stack<Integer> stackT = new Stack<>();

        System.out.println("Эхлэхээс өмнө:");
        System.out.println("Stack S: " + stackS);
        System.out.println("Stack T: " + stackT);

        // Аргыг дуудах
        transfer(stackS, stackT);

        System.out.println("\nШилжүүлсний дараа:");
        System.out.println("Stack S: " + stackS); // Хоосон байх ёстой: []
        System.out.println("Stack T: " + stackT);
        // T-д орох дараалал: (pop 3 -> push 3), (pop 2 -> push 2), (pop 1 -> push 1)
        // Эцсийн байдал: [3 (доод), 2, 1 (орой)]
    }
}
