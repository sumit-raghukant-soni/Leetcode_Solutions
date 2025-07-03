class Solution {
    int vis[] = null, ans = 0;
    public int arrayNesting(int[] nums) {
        int sz = nums.length;
        vis = new int[sz];
        Arrays.fill(vis, -1);

        for(int i=0; i<sz; i++){
            if(vis[i] == -1){
                solve(nums, i);
                ans = ans > vis[i] ? ans : vis[i];
            }
            // System.out.print(vis[i] + ",");
        }

        return ans;
    }

    private int solve(int[] nums, int i){
        
        int cnt = 0;
        vis[i] = 0;
        if(vis[nums[i]] == -1){
            cnt += solve(nums, nums[i]);
        }
        else cnt += vis[nums[i]];

        return vis[i] = cnt+1;
    }
}