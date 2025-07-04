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
    int ans = 0;
    public int distributeCoins(TreeNode root) {
        solve(root);

        return ans;
    }

    private Pair<Integer, Integer> solve(TreeNode root){
        if(root == null) return new Pair(0, 0);
        
        Pair<Integer, Integer> left = solve(root.left), right = solve(root.right);
        int carry = 0, penalty = 0;
        
        carry += left.getKey();
        carry += right.getKey();
        penalty += left.getValue();
        penalty += right.getValue();

        if(root.val >= 1) carry += root.val - 1;
        else penalty += 1;

        if(carry > 0){
            if(carry > penalty){
                carry -= penalty;
                penalty = 0;
            }
            else{
                penalty -= carry;
                carry = 0;
            }
        }

        ans += carry + penalty;        
        return new Pair(carry, penalty);
    }
}