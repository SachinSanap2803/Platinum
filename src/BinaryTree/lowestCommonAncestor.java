package BinaryTree;

import BinarySearchTree.BalancedBinaryTree;

public class lowestCommonAncestor {

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

    public TreeNode Ancestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = Ancestor(root.left, p, q);
        TreeNode right = Ancestor(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}