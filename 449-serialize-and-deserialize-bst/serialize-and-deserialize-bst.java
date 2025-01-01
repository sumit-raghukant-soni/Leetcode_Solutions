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
        if(data.length() == 0) return null;
        i=0;
        return solve(data);
    }
    private TreeNode solve(String data){
        if(data.charAt(i) == '#'){
            i+=2;
            return null;
        }

        String tmp = "";
        while(data.charAt(i) != ','){
            tmp += data.charAt(i++);
        }
        i++;
        TreeNode root = new TreeNode(Integer.parseInt(tmp));
        root.left = solve(data);
        root.right = solve(data);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;