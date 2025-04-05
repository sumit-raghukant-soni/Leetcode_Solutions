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
    private Map<Integer, List<TreeNode>> mp = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        
        for(int i=0; i<=n; i++) mp.put(i, new ArrayList<>());
        mp.get(0).add(null);
        mp.get(1).add(new TreeNode(0));

        for(int i=3; i<=n; i+=2){
            createTree(i);
        }

        return mp.get(n);
    }

    private void createTree(int n){

        for(int i=1; i<n; i+=2){
            int left = i;
            int right = (n-1)-i;
            for(TreeNode l : mp.get(left) ){
                for(TreeNode r : mp.get(right) ){
                    TreeNode root = new TreeNode(0);
                    root.left = clone(l);
                    root.right = clone(r);
                    mp.get(n).add(root);
                }
            }
        }

    }

    private TreeNode clone(TreeNode root){
        if(root == null) return null;
        
        TreeNode curr = new TreeNode(0);
        if(root.left != null) curr.left = clone(root.left);
        if(root.right != null) curr.right = clone(root.right);

        return curr;
    }
}