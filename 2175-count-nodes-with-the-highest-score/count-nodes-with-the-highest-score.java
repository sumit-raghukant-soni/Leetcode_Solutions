class Solution {
    private long ans = 0;
    private Map<Integer, List<Integer>> mp = new HashMap<>();
    private int nodeCount = 0;
    public int countHighestScoreNodes(int[] parents) {
        int sz = parents.length;
        
        for(int i=0; i<sz; i++){
            mp.put(i, new ArrayList<>());
        }

        for(int i=1; i<sz; i++){
            mp.get(parents[i]).add(i);
        }

        solve(0, sz);

        return nodeCount;
    }

    private int solve(int i, int sz){
        long prod = 1;
        int cnt = 1, tmp;

        for(int j : mp.get(i)){
            tmp = solve(j, sz);
            // System.out.println("for " + i + " " + j + " with " + tmp);
            prod *= tmp;
            cnt += tmp;
        }

        // System.out.println(i + " " + prod);
        if(cnt != sz) prod *= sz - cnt;
        // System.out.println(i + " " + prod);
        // ans = ans > prod ? ans : prod;
        if(prod > ans){
            ans = prod;
            nodeCount = 1;
        }
        else if(prod == ans) nodeCount++;

        return cnt;
    }
}


class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int v){
        this.val = v;
        this.left = this.right = null;
    }
}