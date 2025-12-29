public class ArrayCircularQueue {
    private int[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayCircularQueue(int k) {
        capacity = k;
        array = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enqueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % capacity;
        array[rear] = value;
        size++;
        return true;
    }

    public boolean dequeue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return array[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return array[rear];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        int count = 0;
        int i = front;
        while (count < size) {
            System.out.print(array[i] + " ");
            i = (i + 1) % capacity;
            count++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayCircularQueue q = new ArrayCircularQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.display(); // 10 20 30 40
        
        q.dequeue();
        q.display(); // 20 30 40
        
        q.enqueue(50);
        q.enqueue(60); // Wraps around
        q.display(); // 20 30 40 50 60
        
        System.out.println("Full: " + q.isFull()); // true
        q.enqueue(70); // Should fail
    }
}
