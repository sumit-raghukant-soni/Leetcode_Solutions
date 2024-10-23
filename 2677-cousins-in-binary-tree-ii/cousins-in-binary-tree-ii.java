class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        root.val = 0;
        
        while (!q.isEmpty()) {
            int levelSize = q.size();
            int levelSum = 0;
            HashMap<TreeNode, Integer> childSum = new HashMap<>(); 
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                
                if (node.left != null) levelSum += node.left.val;
                if (node.right != null) levelSum += node.right.val;
                
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                
                childSum.put(node, (node.left != null ? node.left.val : 0) + (node.right != null ? node.right.val : 0));
            }
            
            for (TreeNode node : childSum.keySet()) {
                int siblingSum = levelSum - childSum.get(node); 
                if (node.left != null) node.left.val = siblingSum;
                if (node.right != null) node.right.val = siblingSum;
            }
        }
        
        return root;
    }
}
