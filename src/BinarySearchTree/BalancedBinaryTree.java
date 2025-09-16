package BinarySearchTree;

public class BalancedBinaryTree {

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

    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        int h = checkHeight(root);

        return flag;
    }

    public int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = checkHeight(root.left);
        int rightHeight = checkHeight(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1) {
            flag = false;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}