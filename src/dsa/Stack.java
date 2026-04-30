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

    public int peek() {
        return elements[count - 1];
    }

    public int size() {
        return count;
    }

    public void clear() {
        count = 0;
    }

    public boolean contains(int i) {
        for (int x: elements){
            if (x == i) return true;
        }
        return false;
    }
}
