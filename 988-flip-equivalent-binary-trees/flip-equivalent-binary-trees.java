/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if(root1 == null && root2 == null) return true;
            if(root1 == null || root2 == null || root1.val != root2.val) return false;

            if(root1.left == null && root1.right == null && root2.left == null && root2.right == null) return root1.val == root2.val;

            int left1 = root1.left != null ? root1.left.val : -1, left2 = root2.left != null ? root2.left.val : -1;
            int right1 = root1.right != null ? root1.right.val : -1, right2 = root2.right != null ? root2.right.val : -1;

            if(left1 == left2 && right1 == right2) return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
            if(left1 == right2 && right1 == left2) return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
            
            return false;
    }
}