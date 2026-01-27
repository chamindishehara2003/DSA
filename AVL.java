class AVLNode {
    int key, height;
    AVLNode left, right;
    
    public AVLNode(int key) {
        this.key = key;
        this.height = 1;
        this.left = this.right = null;
    }
}

public class AVL {
    private AVLNode root;
    
    // Get height
    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }
    
    // Right rotation
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        
        x.right = y;
        y.left = T2;
        
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        
        return x;
    }
    
    // Left rotation
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        
        y.left = x;
        x.right = T2;
        
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        
        return y;
    }
    
    // Get balance factor
    private int getBalance(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }
    
    // Insert
    public void insert(int key) {
        root = insert(root, key);
    }
    
    private AVLNode insert(AVLNode node, int key) {
        if (node == null) return new AVLNode(key);
        
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // No duplicates
        
        node.height = 1 + Math.max(height(node.left), height(node.right));
        
        int balance = getBalance(node);
        
        // Left Left
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);
        
        // Right Right
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);
        
        // Left Right
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        // Right Left
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        return node;
    }
    
    // Search
    public boolean search(int key) {
        return search(root, key);
    }
    
    private boolean search(AVLNode node, int key) {
        if (node == null) return false;
        if (node.key == key) return true;
        
        return key < node.key ? search(node.left, key) : search(node.right, key);
    }
    
    // Inorder traversal (sorted order)
    public void inorder() {
        inorder(root);
        System.out.println();
    }
    
    private void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }
    
    // Preorder traversal
    public void preorder() {
        preorder(root);
        System.out.println();
    }
    
    private void preorder(AVLNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }
}

