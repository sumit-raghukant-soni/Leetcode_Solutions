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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<TreeNode2, Integer> mp = new HashMap<>();

        List<TreeNode> ans = new ArrayList<>();

        solve(root, mp);

        for(Map.Entry<TreeNode2, Integer> entry : mp.entrySet()){
            if(entry.getValue() > 1){
                ans.add(entry.getKey().getNode());
            }
        }

        return ans;
    }

    private void solve(TreeNode root, HashMap<TreeNode2, Integer> mp){
        if(root == null) return;

        solve(root.left, mp);
        solve(root.right, mp);
        TreeNode2 tmp = new TreeNode2(root);
        mp.put(tmp, mp.getOrDefault(tmp, 0) + 1);
    }
}

class TreeNode2{
    private final TreeNode node;
    public TreeNode2(TreeNode n){
        this.node = n;
    }

    public TreeNode getNode(){
        return this.node;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        TreeNode2 t2 = (TreeNode2) obj;
        return isSameTree(this.node, t2.node);
    }

    private boolean isSameTree(TreeNode a, TreeNode b){
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        return a.val == b.val && isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    @Override
    public int hashCode() {
        return generateTreeHash(node);
    }

    private int generateTreeHash(TreeNode node) {
        if (node == null) return 0;
        return Objects.hash(node.val, generateTreeHash(node.left), generateTreeHash(node.right));
    }
}