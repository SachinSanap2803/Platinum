package BinarySearchTree;

import java.util.*;

public class levelOrderZigzag {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while(!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>(n);
            for(int i=0; i<n; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);

                if(temp.left != null) {
                    queue.add(temp.left);
                }

                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }

            if(!leftToRight) {
                Collections.reverse(list);
            }
            ans.add(list);
            leftToRight = !leftToRight;
        }
        return ans;
    }
}