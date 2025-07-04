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

    private int[] solve(TreeNode root){
        int[] response = {0, 0};
        if(root == null) return response;
        
        int[] left = solve(root.left), right = solve(root.right);
        int carry = left[0] + right[0];
        int penalty = left[1] + right[1];

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
        response[0] = carry;
        response[1] = penalty;     
        return response;
    }
}