package coding.interview.queueStack;

import sun.jvm.hotspot.jdi.IntegerTypeImpl;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class QueueStack  {

    Deque<Integer> deque = new LinkedList<>();


    /** Push element x onto stack. */
    public void push(int x) {
        deque.offerFirst(x);


    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return deque.pollFirst();

    }

    /** Get the top element. */
    public int top() {
        return deque.peekFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {


        return deque.isEmpty();
    }
}
