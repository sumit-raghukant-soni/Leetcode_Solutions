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
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        solve(root, 0);
        return sum;
    }

    private void solve(TreeNode root, int val){
        if(root == null){
            return;
        }
        
        int newVal = (val<<1) + (root.val == 1 ? 1 : 0);
        if(root.left == null && root.right == null){
            sum += newVal;
            return;
        }
        solve(root.left, newVal );
        solve(root.right, newVal );
    }
}