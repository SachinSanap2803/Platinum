package AVLTree;

public class implemantion {
    static class Node {
        int key, height;
        Node left, right;
        Node(int key) {
            this.key = key;
            left = right = null;
            height = 1;
        }
    }

    static Node rightRotate(Node b) {
        Node a = b.left;
        Node temp = a.right;

        // Perform Rotation (swapping)
        a.right = b;
        b.left = temp;

        b.height = 1 + Math.max(height(b.left), height(b.right));
        a.height = 1 + Math.max(height(a.left), height(a.right));

        return a;
    }

    static Node leftRotate(Node a) {
        Node b = a.right;
        Node temp = b.left;

        // Rotation (swapping)
        b.left = a;
        a.right = temp;

        // Recalculate Height
        a.height = 1 + Math.max(height(a.left), height(a.right));
        b.height = 1 + Math.max(height(b.left), height(b.right));

        return b;
    }

    static Node insert(Node root, int key) {
        if(root == null) {
            return new Node(key);
        }

        if(key < root.key) {
            root.left = insert(root.left, key);
        } else if(key > root.key) {
            root.right = insert(root.right, key);
        }else {
            return root;
        }

        // Update the height of tree
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get the balance
        int balance = getBalance(root);

        // Right Rotation
        if(balance > 1 && key < root.left.key) {
            return rightRotate(root);
        }

        // Left Rotation
        if(balance < -1 && key > root.right.key) {
            return leftRotate(root);
        }

        // Left Right Rotation
        if(balance > 1 && key > root.left.key) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Rotation
        if(balance < -1 && key < root.right.key) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.key + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static int getBalance(Node root) {
        if(root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    static int height(Node root) {
        if(root == null) {
            return 0;
        }
        return root.height;
    }

    public static void main(String[] args) {
        Node root = null;

        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preorder(root);
    }
}