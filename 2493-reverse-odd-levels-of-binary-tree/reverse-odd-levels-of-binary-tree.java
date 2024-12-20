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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        boolean change = true;

        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            if(tmp == null){
                if(q.isEmpty()) break;
                else q.add(null);
                tmp = q.poll();
                change = change ? false : true;
            }

            if(!change) tmp.val = st.pop();

            if(tmp.left != null){
                q.add(tmp.left);
                if(change) st.push(tmp.left.val);
            }
            if(tmp.right != null){
                q.add(tmp.right);
                if(change) st.push(tmp.right.val);
            }
        }

        return root;
    }
}