package labSeven.exercise;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackSizeCalculator {

    public static void main(String[] args) {
        // Бодлогын өгөгдөл
        int numPush = 25;
        int numPop = 10;
        int numTop = 12;
        int numIsEmpty = 3;

        // 1. Онолын тооцоолол
        // Stack-ийн хэмжээ нь зөвхөн Push болон Pop-оос хамаарна.
        int finalSize = numPush - numPop;

        System.out.println("Стекийн үйлдлүүд:");
        System.out.println("  Push (Нэмсэн): " + numPush);
        System.out.println("  Pop (Хассан): " + numPop);
        System.out.println("  Top/Peek (Харсан): " + numTop);
        System.out.println("  isEmpty (Шалгасан): " + numIsEmpty);
        System.out.println("----------------------------------------");
        System.out.println("R-6.1 Бодлогын дагуу, S-н эцсийн хэмжээ: " + finalSize);
        System.out.println("\n");

        // 2. Java-н Stack-ийг ашиглан баталгаажуулах жишээ
        Stack<String> S = new Stack<>();

        // 25 удаагийн Push үйлдэл
        for (int i = 1; i <= numPush; i++) {
            S.push("Element-" + i);
        }

        // 12 удаагийн Top (peek) үйлдэл
        for (int i = 0; i < numTop; i++) {
            // Top/Peek нь стекийн хэмжээг өөрчлөхгүй
            try {
                S.peek();
            } catch (EmptyStackException e) {
                // Бодлого: "null утга буцаадаг" - Java-д EmptyStackException үүсгэдэг
            }
        }

        // 3 удаагийн isEmpty шалгалт
        for (int i = 0; i < numIsEmpty; i++) {
            S.isEmpty(); // Хэмжээнд нөлөөлөхгүй
        }

        // 10 удаагийн Pop үйлдэл
        for (int i = 0; i < numPop; i++) {
            S.pop(); // Энэ нь стекийн хэмжээг бууруулна
        }

        System.out.println("Java-н Stack ашиглан баталгаажуулсан хэмжээ:");
        System.out.println("Stack S-ийн одоогийн хэмжээ (S.size()): " + S.size());
    }
}
