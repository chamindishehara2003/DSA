import java.util.LinkedList;
import java.util.Queue;

public class PopFriendlyQueueStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public PopFriendlyQueueStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push operation is O(n)
    public void push(int x) {
        // Add new element to q2
        q2.add(x);
        
        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        
        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop operation is O(1)
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.remove();
    }

    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        PopFriendlyQueueStack stack = new PopFriendlyQueueStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Pop: " + stack.pop()); // Should be 3
        System.out.println("Top: " + stack.top()); // Should be 2
        System.out.println("Pop: " + stack.pop()); // Should be 2
        System.out.println("Pop: " + stack.pop()); // Should be 1
    }
}
