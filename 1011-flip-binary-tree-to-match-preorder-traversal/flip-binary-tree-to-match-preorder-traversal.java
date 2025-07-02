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
    List<Integer> ans = new ArrayList<>();
    boolean flg = false;
    int i=0, n;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if(root.val != voyage[0]){
            ans.add(-1);
            return ans;
        }
        n = voyage.length;

        solve(root, voyage);

        if(flg){
            ans.clear();
            ans.add(-1);
        }

        return ans;
    }

    private void solve(TreeNode root, int[] voyage){
        if(flg){
            return;
        }
        // System.out.println(root.val + " " + voyage[i]);

        i++;
        int tmp = i;
        if(root.left != null){
            if(root.left.val == voyage[i]){
                // System.out.println("Normal");
                solve(root.left, voyage);
                // if(i == n) return;
                if(root.right != null && root.right.val == voyage[i]) solve(root.right, voyage);
                else if(root.right != null) flg = true;
            }
            else if(root.right != null){
                if(root.right.val == voyage[i]){
                    // System.out.println("Change");
                    ans.add(root.val);
                    solve(root.right, voyage);
                    // if(i == n) return;
                    if(root.left != null && root.left.val == voyage[i]) solve(root.left, voyage);
                    else if(root.left != null) flg = true;
                }
                else flg = true;
            }
            else flg = true;
        }
        else if(root.right != null){
            if(root.right.val == voyage[i]){
                // System.out.println("Normal");
                solve(root.right, voyage);
            }
            else flg = true;
        }

        // System.out.println("Out");
    }
}