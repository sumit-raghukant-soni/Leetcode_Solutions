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
    public boolean isCompleteTree(TreeNode root) {
        int cnt = 0, k = 1;
        TreeNode curr = null, prev = root;
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty()){
            curr = q.poll();

            if(curr.left != null){
                if(prev == null) return false;
                q.add(curr.left);
            }
            prev = curr.left;
            if(curr.right != null){
                if(prev == null) return false;
                q.add(curr.right);
            }
            prev = curr.right;
        }

        return true;
    }
}