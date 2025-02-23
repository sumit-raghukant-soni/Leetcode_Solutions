/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int i1;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int sz = preorder.length;
        i1 = 0;
        return solve(preorder, postorder, 0, sz - 1, 0, sz - 1);
    }

    public TreeNode solve(int[] pre, int[] post, int i3, int j1, int i2, int j2) {
        // System.out.println("Call for" + " " + i2 + ":" + j2);
        TreeNode root = new TreeNode(pre[i1]);
        i1++;
        j2--;
        // System.out.println(pre[i1 - 1] + " " + i2 + ":" + j2);
        if (i2 > j2) {
            // System.out.println("Back");
            return root;
        }

        int newj2 = -1;
        if (i1 <= j1) {
            // System.out.println("Find " + pre[i1] + " " + i2 + ":" + j2);
            for (int i = i2; i <= j2; i++) {
                if (post[i] == pre[i1]) {
                    newj2 = i;
                    break;
                }
            }
            if (newj2 != -1) {
                // System.out.println("Found at " + i2 + ":" + newj2);
                root.left = solve(pre, post, i1, j1, i2, newj2);
            }
        }
        // i1++;
        int newi2 = -1;
        if (i1 <= j1) {
            // System.out.println("Find " + pre[i1] + " " + i2 + ":" + j2);
            for (int i = i2; i <= j2; i++) {
                if (post[i] == pre[i1]) {
                    newi2 = i;
                    break;
                }
            }
            if (newi2 != -1) {
                // System.out.println("Found at " + newi2 + ":" + j2);
                root.right = solve(pre, post, i1, j1, newj2 + 1, j2);
            }
        }

        // System.out.println("Back");
        return root;
    }
}