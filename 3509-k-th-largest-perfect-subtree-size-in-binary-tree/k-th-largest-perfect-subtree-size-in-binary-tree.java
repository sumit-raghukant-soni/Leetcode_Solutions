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
    private List<Integer> st = new ArrayList<>();
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        solve(root);

        System.out.println(st);
        if(st.size() < k) return -1;
        Collections.sort(st, Collections.reverseOrder());

        return st.get(k-1);
    }

    private int solve(TreeNode root){
        // System.out.println(root.val);
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            st.add(1);
            return 1;
        }
        // if(root.left == null || root.right == null) return -10000;

        int left = solve(root.left);
        int right = solve(root.right);

        // System.out.println(root.val + " " + left + ":" + right);
        if(left < 0 || right < 0) return -100000;
        if(left == right){
            st.add(left + right + 1);
            return left + right + 1;
        }

        return -100000;
    }
}