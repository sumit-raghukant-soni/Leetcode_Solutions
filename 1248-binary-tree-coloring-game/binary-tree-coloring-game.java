class Solution {
    int ans = 0;
    Map<TreeNode, TreeNode> pmp = new HashMap<>();
    Set<Integer> vis = new HashSet<>();
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int cnt = 0, ans = 0;
        TreeNode curr = null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            curr = q.poll();
            if(curr.left != null){
                pmp.put(curr.left, curr);
                q.add(curr.left);
            }
            if(curr.right != null){
                pmp.put(curr.right, curr);
                q.add(curr.right);
            }
        }
        curr = get(root, x);
        // if(curr != null) System.out.println("Got curr " + curr.val);

        vis.add(curr.val);
        if(curr.left != null && !vis.contains(curr.left.val)){
            vis.add(curr.left.val);
            q.add(curr.left);
        }
        if(curr.right != null && !vis.contains(curr.right.val)){
            vis.add(curr.right.val);
            q.add(curr.right);
        }
        if(pmp.get(curr) != null && !vis.contains(pmp.get(curr).val)){
            vis.add(pmp.get(curr).val);
            q.add(pmp.get(curr));
        }

        while(!q.isEmpty()){
            curr = q.poll();
            ans = Math.max(ans, solve(curr));
        }
        
        return ans > (n/2);
    }

    private TreeNode get(TreeNode root, int x){
        if(root == null) return null;
        if(root.val == x) return root;

        TreeNode left = get(root.left, x), right = get(root.right, x);

        return left != null ? left : right;
    }

    private int solve(TreeNode curr){
        if(curr == null) return 0;
        vis.add(curr.val);
        int cnt = 1;
        
        if(curr.left != null && !vis.contains(curr.left.val)) cnt += solve(curr.left);
        if(curr.right != null && !vis.contains(curr.right.val)) cnt += solve(curr.right);
        if(pmp.get(curr) != null && !vis.contains(pmp.get(curr).val)) cnt += solve(pmp.get(curr));

        return cnt;
    }
}