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
class CBTInserter {
    Queue<TreeNode> q = new LinkedList<>();
    TreeNode root;
    public CBTInserter(TreeNode root) {
        this.root = root;
        updateq(root);
    }
    
    public int insert(int val) {
        if(q.isEmpty()) return -1;
        TreeNode tmp = q.poll();
        TreeNode newNode = new TreeNode(val);

        if(tmp.left == null){
            tmp.left = newNode;
        }
        else{
            tmp.right = newNode;
        }

        q.add(newNode);
        q.add(newNode);

        return tmp.val;
    }
    
    public TreeNode get_root() {
        return root;
    }

    public void updateq(TreeNode curr){
        if(curr == null) return;
        Queue<TreeNode> tmpq = new LinkedList<>();
        tmpq.add(curr);

        while(!tmpq.isEmpty()){
            TreeNode c = tmpq.poll();
            if(c.left == null){
                q.add(c);
            } 
            if(c.right == null){
                q.add(c);
            } 
            if(c.left != null){
                tmpq.add(c.left);
            }
            if(c.right != null){
                tmpq.add(c.right);
            }
        }
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */