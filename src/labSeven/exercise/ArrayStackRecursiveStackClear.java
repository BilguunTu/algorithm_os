package labSeven.exercise;

import java.util.Stack;

public class ArrayStackRecursiveStackClear {

    public static <E> void clearStackRecursively(Stack<E> S) {

        // 1. Үндсэн Нөхцөл (Base Case): 
        // Хэрэв стек хоосон бол, рекурсийг зогсооно.
        if (S.isEmpty()) {
            return;
        }

        // 2. Рекурсив Алхам (Recursive Step):
        // а) Оройн элементийг хасах (Pop хийх)
        S.pop();

        // б) Үлдсэн стек дээр өөрийгөө дахин дуудах
        // Энэ нь асуудлыг нэгээр багасгаж (элемент хасах) шийдэж байна.
        clearStackRecursively(S);
    }

    public static void main(String[] args) {
        Stack<String> myStack = new Stack<>();

        // Стекийг өгөгдлөөр дүүргэх
        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        myStack.push("D");

        System.out.println("--- Рекурсив Хоослох Аргын Хэрэгжилт ---");
        System.out.println("Эхний байдал (Size: " + myStack.size() + "): " + myStack);

        // Рекурсив функцийг дуудах
        clearStackRecursively(myStack);

        System.out.println("\nХоосолсны дараах байдал:");
        System.out.println("Stack: " + myStack);
        System.out.println("Size (Хүлээгдэж буй: 0): " + myStack.size());

        // Баталгаажуулалт
        if (myStack.isEmpty()) {
            System.out.println("Үр дүн: Стек амжилттай хоосорсон байна.");
        }
    }
}
