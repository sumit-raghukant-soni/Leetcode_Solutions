/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(k == 0){
            ans.add(target.val);
            return ans;
        }

        Queue<Integer> q = new LinkedList<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Set<Integer> vis = new HashSet<>();

        traverse(root, adjList, -1);
        if(adjList.size() <= 1) return ans;

        q.add(target.val);
        q.add(null);
        
        while(!q.isEmpty()){
            // System.out.println(q);
            Integer curr = q.poll();
            if(curr == null){
                k--;
                if(q.isEmpty() || k == 0) break;
                curr = q.poll();
                q.add(null);
            }
            vis.add(curr);
            for(int i : adjList.get(curr)){
                if(!vis.contains(i)) q.add(i);
            }
        }

        // System.out.println(q);
        
        while(!q.isEmpty()){
            ans.add(q.poll());
        }

        return ans;
    }

    private void traverse(TreeNode root, Map<Integer, List<Integer>> adjList, int parent){
        if(root == null) return;

        if(parent != -1){
            if(!adjList.containsKey(root.val)) adjList.put(root.val, new ArrayList<>());
            if(!adjList.containsKey(parent)) adjList.put(parent, new ArrayList<>());
            adjList.get(root.val).add(parent);
            adjList.get(parent).add(root.val);
        }

        if(root.left != null){
            traverse(root.left, adjList, root.val);
        }
        if(root.right != null){
            traverse(root.right, adjList, root.val);       
        }
    }
}