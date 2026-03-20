package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void pushXPopX(){}
}
