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
    private int ans, freq=0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        solve(root);

        return freq-1;
    }

    private Pair<Integer, Integer> solve(TreeNode root){
        if(root == null) return new Pair(Integer.MAX_VALUE, 0);

        Pair<Integer, Integer> left = solve(root.left), right = solve(root.right);
        int f = 1, val = 1;
        if(left.getKey() == root.val){
            f += left.getValue();
            val += left.getValue();
        }
        if(right.getKey() == root.val){
            f += right.getValue();
            val = Math.max(val, 1 + right.getValue());
        }

        if(f > freq){
            ans = root.val; freq = f;
        }

        Pair<Integer, Integer> p = new Pair(root.val, val);
        // System.out.println(p.getKey() + " " + p.getValue() + " : " + left.getKey() + ":" + left.getValue() + " = " + right.getKey() + ":" + right.getValue());

        return p;
    }
}