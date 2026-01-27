class BSTNode {
    int key;
    BSTNode left, right;
    
    public BSTNode(int key) {
        this.key = key;
        left = right = null;
    }
}

public class BST {
    private BSTNode root;
    
    public void insert(int key) {
        root = insertRec(root, key);
    }
    
    private BSTNode insertRec(BSTNode root, int key) {
        if (root == null) {
            root = new BSTNode(key);
            return root;
        }
        
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        
        return root;
    }
    
    public boolean search(int key) {
        return searchRec(root, key);
    }
    
    private boolean searchRec(BSTNode root, int key) {
        if (root == null) return false;
        if (root.key == key) return true;
        
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }
    
    public void inorder() {
        inorderRec(root);
    }
    
    private void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
}

