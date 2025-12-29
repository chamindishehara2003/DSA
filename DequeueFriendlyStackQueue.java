import java.util.Stack;

public class DequeueFriendlyStackQueue {
    private Stack<Integer> s1; // Stores elements in reverse order (stack top is end of queue)
    private Stack<Integer> s2; // Stores elements in queue order (stack top is front of queue)

    public DequeueFriendlyStackQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Enqueue operation is O(n)
    public void enqueue(int x) {
        // Move all elements from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        
        // Push the new item onto s1 (which is now empty)
        // Wait, if I want Dequeue to be O(1), elements must be in s1 sorted such that top is front.
        // Let's rethink. 
        // Goal: Dequeue is O(1). This means the top of one stack implies the front of the queue directly.
        // Let s1 be the "main" stack where s1.pop() gives the queue front.
        // To enqueue 'x' while keeping s1 ready for O(1) pop:
        // 1. Move all from s1 to s2.
        // 2. Push x to s1.
        // 3. Move all back from s2 to s1.
        // Now s1 has x at the bottom, and previous elements on top. s1.pop() is old elements.
        
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        
        s1.push(x);
        
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Dequeue operation is O(1)
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return s1.pop();
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return s1.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        DequeueFriendlyStackQueue queue = new DequeueFriendlyStackQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeue: " + queue.dequeue()); // Should be 1
        System.out.println("Dequeue: " + queue.dequeue()); // Should be 2
        
        queue.enqueue(4);
        System.out.println("Dequeue: " + queue.dequeue()); // Should be 3
        System.out.println("Dequeue: " + queue.dequeue()); // Should be 4
    }
}
