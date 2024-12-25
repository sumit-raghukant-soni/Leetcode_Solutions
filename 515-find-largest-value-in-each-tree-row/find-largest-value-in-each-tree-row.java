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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int maxi = root.val;

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                ans.add(maxi);
                if(q.isEmpty()) break;
                q.add(null);
                curr = q.poll();
                maxi = curr.val;
            }

            maxi = Math.max(maxi, curr.val);
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }

        return ans;
    }
}