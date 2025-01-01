/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#";

        String left = serialize(root.left);
        String right = serialize(root.right);
        return Integer.toString(root.val) + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    int i;
    public TreeNode deserialize(String data) {
        // System.out.println(data);
        if(data.length() == 0) return null;
        i=0;
        return solve(data, data.length());
    }
    private TreeNode solve(String data, int sz){
        if(data.charAt(i) == '#'){
            i+=2;
            return null;
        }

        String tmp = "";
        while(i < sz && data.charAt(i) != ','){
            tmp += data.charAt(i++);
        }
        i++;
        TreeNode root = new TreeNode(Integer.parseInt(tmp));
        // System.out.println(root.val + " left" + i);
        root.left = solve(data, sz);
        // System.out.println(root.val + " right" + i);
        root.right = solve(data, sz);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;