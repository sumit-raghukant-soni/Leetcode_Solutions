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
    private TreeNode ans = null;
    private int maxDepth = -1;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        solve(root, 0);

        return ans;
    }

    public int solve(TreeNode root, int depth){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            if(depth > maxDepth){
                maxDepth = depth;
                ans = root;
            }
            return depth;
        }

        int left = solve(root.left, depth + 1), right = solve(root.right, depth + 1);
        maxDepth = Math.max(maxDepth, Math.max(left, right));
        if(left == right && left == maxDepth) ans = root;
        
        System.out.println(root.val + " " + left + ":" + right);
        return Math.max(left, right);
    }
}