package stacks.and.queues;

import java.util.Stack;

public class ATaleOfTwoStacks {

    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.add(value);
        }

        public T peek() {
            reFill();
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            reFill();
            return stackOldestOnTop.pop();
        }

        public void reFill() {
            if (stackOldestOnTop.isEmpty())
                while(!stackNewestOnTop.isEmpty())
                    stackOldestOnTop.push(stackNewestOnTop.pop());
        }
    }

    public static void main(String[] args) {

    }
}
