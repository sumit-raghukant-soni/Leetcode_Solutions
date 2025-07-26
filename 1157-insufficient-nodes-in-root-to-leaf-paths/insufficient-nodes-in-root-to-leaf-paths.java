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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return (TreeNode) solve(root, limit, 0)[0];
    }

    private Object[] solve(TreeNode root, int limit, int sum){
        sum += root.val;
        Object[] tmp = new Object[2];
        if(root.left == null && root.right == null){
            if(limit <= sum){
                tmp[0] = root;
                tmp[1] = limit <= sum;
            }
            else{
                tmp[0] = null;
                tmp[1] = false;
            }
            return tmp;
        } 

        boolean flg = false;
        Object[] a = null;
        if(root.left != null){
            a = solve(root.left, limit, sum);
            root.left = (TreeNode) a[0];
            flg = flg | (boolean) a[1];
        }
        if(root.right != null){
            a = solve(root.right, limit, sum);
            root.right = (TreeNode) a[0];
            flg = flg | (boolean) a[1];
        }

        if(flg){
            tmp[0] = root;
            tmp[1] = true;
        }
        else{
            tmp[0] = null;
            tmp[1] = false;
        }
        return tmp;
    }
}