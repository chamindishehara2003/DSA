public class CircularDoublyLinkedList {
    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head = null;
    Node tail = null;

    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            head.next = head;
            head.prev = head;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
            tail = newNode;
        }
    }

    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of circular doubly linked list: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public void displayReverse() {
        Node current = tail;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of circular doubly linked list (Reverse): ");
        do {
            System.out.print(current.data + " ");
            current = current.prev;
        } while (current != tail);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList cdList = new CircularDoublyLinkedList();

        cdList.add(1);
        cdList.add(2);
        cdList.add(3);
        cdList.add(4);

        cdList.display();
        cdList.displayReverse();
    }
}
