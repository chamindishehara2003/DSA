import java.util.Stack;

public class EnqueueFriendlyStackQueue {
    private Stack<Integer> s1; // For enqueue
    private Stack<Integer> s2; // For dequeue

    public EnqueueFriendlyStackQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Enqueue is O(1)
    public void enqueue(int x) {
        s1.push(x);
    }

    // Dequeue is O(n) worst case, O(1) amortized
    public int dequeue() {
        if (s1.isEmpty() && s2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    public int peek() {
        if (s1.isEmpty() && s2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        EnqueueFriendlyStackQueue queue = new EnqueueFriendlyStackQueue();
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
