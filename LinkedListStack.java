public class LinkedListStack {
    private class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }
    
    private Node top;
    
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
    }
    
    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        int res = top.data;
        top = top.next;
        return res;
    }
    
    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return top.data;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(10);
        stack.push(20);
        System.out.println(stack.pop()); // 20
        System.out.println(stack.pop()); // 10
    }
}
