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
        st.push(new Pair(root, 0));

        while(i < sz){
            // for(Pair<TreeNode, Integer> p : st){
            //     System.out.print(p.getKey().val + " " + p.getValue() + ", ");
            // }
            // System.out.println();
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
            // System.out.println(tmp + " " + st.peek().getKey().val + " with " + cnt);
            TreeNode curr = st.peek().getKey();
            if(curr.left == null){
                // System.out.println("added on left");
                curr.left = new TreeNode(Integer.valueOf(tmp));
                st.push(new Pair(curr.left, cnt));
                i = i2;
            }
            else{
                // System.out.println("added on right");
                curr.right = new TreeNode(Integer.valueOf(tmp));
                st.pop();
                st.push(new Pair(curr.right, cnt));
                i = i2;
            }
        }

        return root;
    }
}