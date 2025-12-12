package labSeven.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArrayStackOperations {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> poppedValues = new ArrayList<>();

        System.out.println("--- R-6.3 Үйлдлүүдийн Гүйцэтгэл ---");

        // 1. push(5)
        stack.push(5);

        // 2. push(3)
        stack.push(3);

        // 3. pop() -> 3
        poppedValues.add(stack.pop());

        // 4. push(2)
        stack.push(2);

        // 5. push(8)
        stack.push(8);

        // 6. pop() -> 8
        poppedValues.add(stack.pop());

        // 7. pop() -> 2
        poppedValues.add(stack.pop());

        // 8. push(9)
        stack.push(9);

        // 9. push(1)
        stack.push(1);

        // 10. pop() -> 1
        poppedValues.add(stack.pop());

        // 11. push(7)
        stack.push(7);

        // 12. push(6)
        stack.push(6);

        // 13. pop() -> 6
        poppedValues.add(stack.pop());

        // 14. pop() -> 7
        poppedValues.add(stack.pop());

        // 15. push(4)
        stack.push(4);

        // 16. pop() -> 4
        poppedValues.add(stack.pop());

        // 17. pop() -> 9
        poppedValues.add(stack.pop());

        System.out.println("\nPOP оператороор буцаагдсан утгуудын дараалал:");
        System.out.println(poppedValues);

        System.out.println("\nҮйлдлүүд дууссаны дараах стекийн эцсийн утга (Size = 1):");
        System.out.println(stack); // Үлдэгдэл: [5]
    }
}
