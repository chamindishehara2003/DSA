public class UnboundedArrayStack {
    private int[] array;
    private int top;
    private int capacity;

    public UnboundedArrayStack() {
        capacity = 2; // Initial small capacity
        array = new int[capacity];
        top = -1;
    }

    public void push(int x) {
        if (top == capacity - 1) {
            resize(capacity * 2); // Double the size
        }
        array[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int value = array[top];
        top--;
        
        // Shrink size if necessary (e.g., if 1/4th full)
        if (top > 0 && top == capacity / 4 - 1) {
            resize(capacity / 2);
        }
        
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public int getCapacity() {
        return capacity;
    }

    private void resize(int newCapacity) {
        int[] newArray = new int[newCapacity];
        for (int i = 0; i <= top; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        capacity = newCapacity;
        System.out.println("Resized to: " + capacity);
    }

    public static void main(String[] args) {
        UnboundedArrayStack stack = new UnboundedArrayStack();
        stack.push(1);
        stack.push(2); // Capacity might resize
        stack.push(3); // Capacity might resize
        stack.push(4);
        stack.push(5);

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop()); // Might trigger shrink
        System.out.println("Pop: " + stack.pop());
    }
}
