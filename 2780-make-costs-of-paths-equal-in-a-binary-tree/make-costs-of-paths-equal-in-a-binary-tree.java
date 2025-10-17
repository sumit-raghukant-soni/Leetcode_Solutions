class Solution {
    Map<Integer, List<Integer>> mp = new HashMap<>();
    int ans = 0;
    public int minIncrements(int n, int[] cost) {
        int i=0;
        Tree root = new Tree(cost[i], i);
        Queue<Tree> q = new LinkedList<>();
        q.add(root);

        while(i < n-1){
            // System.out.println(i + " " + n);
            Tree curr = q.poll();
            Tree left = new Tree(cost[++i], i);
            Tree right = new Tree(cost[++i], i);
            // System.out.println(curr.ind + " " + left.ind + ":" + right.ind);
            curr.left = left;
            curr.right = right;
            q.add(left);
            q.add(right);
        }

        solve(root);

        return ans;
    }

    private int solve(Tree root){
        if(root == null) return 0;
        // System.out.println("Inside " + root.ind);
        int sum = 0;
        int left = solve(root.left), right = solve(root.right);
        ans += Math.abs(left - right);
        // System.out.println(root.ind);
        // System.out.println(left + ":" + right);
        return Math.max(left, right) + root.val;
    }
}

class Tree{
    int val, ind;
    Tree left, right;
    Tree(int v, int i){
        this.val = v;
        this.ind = i;
    }
}