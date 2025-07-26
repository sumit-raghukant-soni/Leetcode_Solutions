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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return solve(root, limit, 0).getKey();
    }

    private Pair<TreeNode, Boolean> solve(TreeNode root, int limit, int sum){
        sum += root.val;
        if(root.left == null && root.right == null){
            if(limit <= sum) return new Pair(root, limit <= sum);
            return new Pair(null, false);
        } 

        boolean flg = false;
        Pair<TreeNode, Boolean> a;
        if(root.left != null){
            a = solve(root.left, limit, sum);
            root.left = a.getKey();
            flg = flg | a.getValue();
        }
        if(root.right != null){
            a = solve(root.right, limit, sum);
            root.right = a.getKey();
            flg = flg | a.getValue();
        }

        // System.out.println("Here " + root.val + " and sum is " + sum + " " + flg);
        // if(flg){
            // System.out.println("Not Deleted");
            // return ;
        // }

        return flg ? new Pair(root, true) : new Pair(null, false);
    }
}