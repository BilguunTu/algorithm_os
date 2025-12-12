package labSeven.example;

// The ArrayStack class correctly implements the Stack interface
public class ArrayStack<E> implements Stack<E> {

    public static final int CAPACITY = 1000; // default array capacity
    private E[] data;
    private int t = -1; // index of the top element in the stack

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) { // constructs stack with given capacity
        // Unchecked cast: this is standard practice for generic arrays in Java
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return (t + 1);
    }

    /**
     * Tests whether the stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return (t == -1);
    }

    /**
     * Inserts an element at the top of the stack.
     */
    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[++t] = e; // increment t and then store the element
    }

    /**
     * Returns, but does not remove, the element at the top of the stack.
     */
    @Override
    public E top() {
        if (isEmpty()) {
            return null; // or throw a NoSuchElementException
        }
        return data[t];
    }

    /**
     * Removes and returns the element at the top of the stack.
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            return null; // or throw a NoSuchElementException
        }
        E answer = data[t];
        data[t] = null; // helps with garbage collection
        t--; // decrement t
        return answer;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a stack of Integers
        Stack<Integer> sak = new ArrayStack<>();

        sak.push(10);
        sak.push(20);

        // Fixed the syntax error in the original System.out.println
        System.out.println("Size: " + sak.size()); // Expected output: Size: 2
        System.out.println("Top element: " + sak.top()); // Expected output: Top element: 20
        System.out.println("Popped element: " + sak.pop()); // Expected output: Popped element: 20
        System.out.println("New Size: " + sak.size()); // Expected output: New Size: 1
    }

    // *** The incorrect push(int i) method was removed from here. ***
}
