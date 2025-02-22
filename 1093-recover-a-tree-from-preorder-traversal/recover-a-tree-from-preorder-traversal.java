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
    public TreeNode recoverFromPreorder(String path) {
        int sz = path.length();
        if(sz == 0) return null;
        Stack<Pair<TreeNode, Integer>> st = new Stack<>();

        int i=0;
        String tmp = "";
        while(i < sz && path.charAt(i) != '-'){
            tmp += path.charAt(i++); 
        }

        TreeNode root = new TreeNode(Integer.valueOf(tmp));
        TreeNode curr = null, newNode = null;
        st.push(new Pair(root, 0));

        while(i < sz){
            int i2 = i, cnt = 0;
            while(i2 < sz && path.charAt(i2) == '-'){
                cnt++; i2++;
            }
            while(cnt <= st.peek().getValue()) { st.pop(); }
            
            tmp = "";
            while(i2 < sz && path.charAt(i2) != '-'){
                tmp += path.charAt(i2++); 
            }
            if(st.isEmpty()) break;

            curr = st.peek().getKey();
            newNode = new TreeNode(Integer.valueOf(tmp));
            if(curr.left == null){
                curr.left = newNode;
            }
            else{
                curr.right = newNode;
                st.pop();
            }
            st.push(new Pair(newNode, cnt));
            i = i2;
        }

        return root;
    }
}