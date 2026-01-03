public class RabbitProblem {
    // Inner class for Linked List Node
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Solution 1: Floyd’s Cycle-Finding Algorithm (Tortoise and Hare)
    // This detects if a linked list has a cycle ("Rabbit" running in a loop)
    public boolean hasCycle(Node head) {
        if (head == null) return false;
        
        Node tortoise = head;
        Node hare = head;
        
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;      // Move 1 step
            hare = hare.next.next;         // Move 2 steps
            
            if (tortoise == hare) {
                return true; // Cycle detected
            }
        }
        return false;
    }

    // Solution 2: Fibonacci Sequence (Standard "Rabbit Population" Problem)
    // Calculates pairs of rabbits after n months
    public int countRabbitPairs(int months) {
        if (months == 0) return 0;
        if (months == 1) return 1;
        
        int a = 0; // Month 0
        int b = 1; // Month 1
        
        for (int i = 2; i <= months; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        RabbitProblem solver = new RabbitProblem();

        // Test 1: Cycle Detection (Tortoise and Hare)
        System.out.println("--- Test 1: Cycle Detection ---");
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; // Create a loop (4 -> 2)
        
        boolean hasCycle = solver.hasCycle(head);
        System.out.println("Has Cycle: " + hasCycle); // Expected: true

        // Test 2: Rabbit Population (Fibonacci)
        System.out.println("\n--- Test 2: Rabbit Population (Fibonacci) ---");
        int months = 10;
        System.out.println("Rabbit pairs after " + months + " months: " + solver.countRabbitPairs(months));
    }
}
