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
    public boolean isEvenOddTree(TreeNode root) {
        int level = 0, lastUsed = -1, tmp = -1;
        TreeNode curr = null;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            curr = q.poll();
            if(curr == null){
                if(q.isEmpty()) break;
                curr = q.poll();
                q.add(null);
                level++;
                tmp = (level&1) == 1 ? Integer.MAX_VALUE : -1;
            }
            // System.out.println(level + " " + curr.val + " " + tmp);
            if((level&1) == 1){
                if(curr.val >= tmp || (curr.val&1) == 1) return false;
            }
            else{
                if(curr.val <= tmp || (curr.val&1) == 0) return false;
            }
            tmp = curr.val;
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }

        return true;
    }
}