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
    public int minimumOperations(TreeNode root) {
        if(root == null) return 0;

        int moves = 0, i = 0;
        Queue<TreeNode> q = new LinkedList<>();
        Map<Integer, Integer> value_pos = new HashMap<>();
        List<Integer> arr = new ArrayList<>(), target = new ArrayList<>();

        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            TreeNode currNode = q.poll();
            if(currNode == null){
                if(q.isEmpty()) break;
                q.add(null);

                Collections.sort(target);
                for (int j = 0; j < arr.size(); j++) {
                    if (!arr.get(j).equals(target.get(j))) {
                        moves++;

                        int curPos = value_pos.get(target.get(j));
                        value_pos.put(arr.get(j), curPos);
                        arr.set(curPos, arr.get(j));
                    }
                }
                
                arr.clear();
                target.clear();
                i=0;
                continue;
            }

            if(currNode.left != null){
                q.add(currNode.left);
                value_pos.put(currNode.left.val, i++);
                arr.add(currNode.left.val);
                target.add(currNode.left.val);
            }
            if(currNode.right != null){
                q.add(currNode.right);
                value_pos.put(currNode.right.val, i++);
                arr.add(currNode.right.val);
                target.add(currNode.right.val);
            }
        }

        return moves;
    }
}