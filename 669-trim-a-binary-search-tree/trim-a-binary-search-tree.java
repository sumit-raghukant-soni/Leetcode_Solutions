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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        if(root.left == null && root.right == null){
            if(root.val >= low && root.val <= high) return root;
            return null;
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        
        if(root.val < low || root.val > high){
            if(root.left == null) root = root.right;
            else if(root.right == null) root = root.left;
            else{
                TreeNode tmp = getSuccessor(root);
                root.val = tmp.val;
                root.right = trimBST(root.right, low, high);
                return root;
            }
        }


        return root;
    }

    private TreeNode getSuccessor(TreeNode root){
        root = root.right;
        while(root != null && root.left != null){
            root = root.left;
        }
        return root;
    }
}