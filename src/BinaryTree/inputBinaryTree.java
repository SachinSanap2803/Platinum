package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class inputBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

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
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if(temp.left == null) {
                temp.left = new Node(data);
                break;
            } else {
                queue.add(temp.left);
            }

            if(temp.right == null) {
                temp.right = new Node(data);
                break;
            } else {
                queue.add(temp.right);
            }
        }
        return root;
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

        System.out.print("Level Order Traversal : ");
        levelOrder(root);
    }
}