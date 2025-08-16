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
    long totalSum = 0, ans = 0, MOD = 1000000007;
    public int maxProduct(TreeNode root) {
        totalSum = calc(root);

        solve(root);

        return (int) (ans % MOD);
    }

    private long solve(TreeNode root){
        if(root == null) return 0;

        long left = solve(root.left), right = solve(root.right);

        long tmp = ((totalSum - right) * right );
        ans = ans > tmp ? ans : tmp;
        tmp = ((totalSum - left) * left );
        ans = ans > tmp ? ans : tmp;

        return root.val + left + right;
    }

    private long calc(TreeNode root){
        if(root == null) return 0;

        return root.val + calc(root.left) + calc(root.right);
    }
}