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
    List<Integer> lst = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        collect(root);

        return solve(lst, 0, lst.size()-1);
    }

    private TreeNode solve(List<Integer> lst, int i, int j){
        // System.out.println(i + " " + j);
        if(i > j) return null;
        TreeNode root = new TreeNode(lst.get(i));
        if(i == j) return root;

        int mid = i + (j-i)/2;
        // System.out.println(mid);
        root = new TreeNode(lst.get(mid));
        root.left = solve(lst, i, mid-1);
        root.right = solve(lst, mid+1, j);

        return root;
    }

    private void collect(TreeNode root){
        if(root == null) return;

        collect(root.left);
        lst.add(root.val);
        collect(root.right);
        root.left = null;
        root.right = null;
    }
}