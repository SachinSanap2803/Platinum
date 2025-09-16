package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BST {

    static class Node {
        int data;
        Node left;Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        }

        if(data < root.data) {
            root.left = insert(root.left, data);
        }
        if(data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    static Node delete(Node root, int data) {
        if(root == null) {
            return root;
        }

        if(root.data > data) {
            root.left = delete(root.left, data);
        } else if(root.data < data) {
            root.right = delete(root.right, data);
        } else {
            if(root.left == null && root.right == null) {
                root = null;
                return root;
            } else if (root.left == null) {
                root = root.right;
                return root;
            } else if(root.right == null) {
                root = root.left;
                return root;
            } else {
                Node temp = inorderSuccessor(root.right);
                root.data = temp.data;

                root.right = delete(root.right, temp.data);
            }
        }
        return root;
    }

    static Node inorderSuccessor(Node root) {
        Node curr = root;
        while(curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    static void levelOrder(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");

            if(temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no. nodes you want : ");
        int n = sc.nextInt();

        Node root = null;

        System.out.print("Enter Data : ");
        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            root = insert(root, x);
        }

        System.out.print("Level Order Traversal before deleting: ");
        levelOrder(root);
        System.out.println();

        delete(root, 6);

        System.out.print("Level Order Traversal after Deleting: ");
        levelOrder(root);
    }
}