public class LinkedListFIFOQueue {
    private class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }
    
    private Node front, rear;
    
    public void enqueue(int x) {
        Node newNode = new Node(x);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    
    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        int res = front.data;
        front = front.next;
        if (front == null) rear = null;
        return res;
    }
    
    public boolean isEmpty() {
        return front == null;
    }
    
    public static void main(String[] args) {
        LinkedListFIFOQueue q = new LinkedListFIFOQueue();
        q.enqueue(10);
        q.enqueue(20);
        System.out.println(q.dequeue()); // 10
        System.out.println(q.dequeue()); // 20
    }
}
