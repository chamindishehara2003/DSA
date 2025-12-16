import java.util.LinkedList;
import java.util.Queue;

public class PushFriendlyQueueStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public PushFriendlyQueueStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push operation is O(1)
    public void push(int x) {
        q1.add(x);
    }

    // Pop operation is O(n)
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        
        // Move all elements except the last one from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        
        // The last element is the one to be popped
        int top = q1.remove();
        
        // Swap q1 and q2 so q1 is always the active queue
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        
        return top;
    }

    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        
        int top = q1.remove();
        q2.add(top); // Add it back to q2
        
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        
        return top;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        PushFriendlyQueueStack stack = new PushFriendlyQueueStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Pop: " + stack.pop()); // Should be 3
        System.out.println("Top: " + stack.top()); // Should be 2
        System.out.println("Pop: " + stack.pop()); // Should be 2
        System.out.println("Pop: " + stack.pop()); // Should be 1
    }
}
