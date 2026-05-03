package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    private Stack stack;
    @BeforeEach
    public void setup(){
        stack = new Stack();
    }
    @Test
    @DisplayName("Stack should be empty")
    public void isEmpty(){

        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("Stack should not be empty after adding an element")
    public void isNotEmpty(){

        assertTrue(stack.isEmpty());
        stack.push(2);
        assertFalse(stack.isEmpty());
    }

    @Test
    @DisplayName("Stack should be empty Push one element Pop one element")
    public void pushPopEmpty(){

        stack.push(2);
        assertFalse(stack.isEmpty());

        int i = stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("Stack should not be empty Push two element Pop one element")
    public void pushTwoPopOneNotEmpty(){

        stack.push(2);
        assertFalse(stack.isEmpty());

        int i = stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("Push x Pop should return x")
    public void pushXPopX(){
        stack.push(2);
        stack.push(3);
        stack.pop();
        assertFalse(stack.isEmpty());
    }

    @Test
    public void pushXPopXStackIsEmpty(){
        int x = 2;
        stack.push(x);
        assertFalse(stack.isEmpty());

        assertEquals(x, stack.pop());

        assertTrue(stack.isEmpty());
    }

    @Test
    public void lastInFirstOutStackOrder(){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void testPeek(){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.peek());
        assertEquals(3, stack.pop());
    }

    @Test
    public void testCheckSize(){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
    }

    @Test
    public void testClearStack(){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        stack.clear();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testStackContainsElement(){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        assertTrue(stack.contains(2));
    }

    @Test
    public void testDoesNotStackContainsElement(){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        assertFalse(stack.contains(5));
    }
}
