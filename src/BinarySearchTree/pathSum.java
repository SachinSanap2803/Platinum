package BinarySearchTree;

public class pathSum {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null) {
            return targetSum == root.data;
        }

        return hasPathSum(root.left, targetSum - root.data) || hasPathSum(root.right, targetSum - root.data);
    }
}