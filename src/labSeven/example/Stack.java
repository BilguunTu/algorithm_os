package labSeven.example;

public interface Stack<E> {

    /**
     * Returns the number of elements in the stack.
     */
    int size();

    /**
     * Tests whether the stack is empty.
     */
    boolean isEmpty();

    /**
     * Inserts an element at the top of the stack.
     */
    void push(E e) throws IllegalStateException;

    /**
     * Returns, but does not remove, the element at the top of the stack.
     */
    E top();

    /**
     * Removes and returns the element at the top of the stack.
     */
    E pop();
}
