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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        return solve(root, null, val);
    }
    
    private boolean flg = false;
    private TreeNode solve(TreeNode root, TreeNode parent, int val){
        if(!flg && root == null){
            flg = true;
            TreeNode tmp = new TreeNode(val);
            tmp.left = root;
            return tmp;
        }
        if(!flg && root.val < val){
            flg = true;
            TreeNode tmp = new TreeNode(val);
            tmp.left = root;
            if(parent!= null && parent.left != null && parent.left.val == root.val) parent.left = tmp;
            else if(parent != null) parent.right = tmp;
            return tmp;
        }

        if(!flg) root.right = solve(root.right, root, val);
        if(!flg) root.left = solve(root.left, root, val);

        return root;
    }
}