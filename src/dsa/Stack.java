package dsa;

public class Stack {
private int[] elements = new int[52];
    private int count = 0;

    public boolean isEmpty() {
        return count == 0;
    }

    public void push(int element) {
        elements[count++] = element;
    }

    public int pop() {
        return elements[--count];

    }
}
