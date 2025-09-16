package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTree {

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

    static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void postOrder(Node root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    static void levelOrder(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

//        while (!queue.isEmpty()) {
//            Node temp = queue.poll();
//            System.out.print(temp.data + " ");
//
//            if(temp.left != null) {
//                queue.add(temp.left);
//            }
//            if(temp.right != null) {
//                queue.add(temp.right);
//            }
//        }

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i=0; i<levelSize; i++) {
                Node temp = queue.poll();
                System.out.print(temp.data + " ");

                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        System.out.print("Inorder traversal : ");
        inOrder(root);
        System.out.println();

        System.out.print("Preorder traversal : ");
        preOrder(root);
        System.out.println();

        System.out.print("Postorder traversal : ");
        postOrder(root);
        System.out.println();

        System.out.println("Level Order traversal : ");
        levelOrder(root);
    }

    public static class BinaryTreeInorderTraversal {
        static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if(root == null) {
                return list;
            }
            return inorder(root, list);
        }

        public List<Integer> inorder(TreeNode root, List<Integer> list) {
            if(root.left != null) {
                inorder(root.left, list);
            }
            list.add(root.val);
            if(root.right != null) {
                inorder(root.right, list);
            }

            return list;
        }

        public static void main(String[] args) {

        }


    }
}