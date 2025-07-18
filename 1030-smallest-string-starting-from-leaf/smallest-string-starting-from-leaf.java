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
    public String smallestFromLeaf(TreeNode root) {
        return solve(root, "");
    }

    private String solve(TreeNode root, String curr){
        if(root == null) return curr;

        curr = ((char) (root.val + 'a')) + curr;
        String left = solve(root.left, curr), right = solve(root.right, curr);

        // System.out.println(((char) (root.val + 'a')) + " left = " + left);
        // System.out.println(((char) (root.val + 'a')) + " right = " + right);

        if(root.left == null) return right;
        if(root.right == null) return left;

        // System.out.println(left + " " + right + " " + (left.compareTo(right)));
        if(left.compareTo(right) <= 0) return left;
        return right;
    }
}