package BinarySearchTree;

public class ValidateBinarySearchTree {

     public class TreeNode {
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

    public boolean isValidBST(TreeNode root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean check(TreeNode root, int min, int max) {
         if(root == null) {
             return true;
         }
         if(root.val <= min && root.val >= max) {
             return false;
         }

         boolean leftAns =  check(root.left, min, root.val);
         boolean rightAns = check(root.right, root.val, max);

         return leftAns && rightAns;
    }

    public static void main(String[] args) {

    }
}