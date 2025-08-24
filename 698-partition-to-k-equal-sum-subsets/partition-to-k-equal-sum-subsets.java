class Solution {
    int vis[] = null, visV = 0;
    int dp[][][] = null;
    Map<List<Integer>, Integer> dp2 = new HashMap<>();
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sz = nums.length, sum = 0;

        vis = new int[sz];
        Arrays.sort(nums);
        for(int i : nums) sum += i;
        // int tmp = (int) Math.pow(2, sz);
        // dp = new int[tmp][k][(sum/k)+1];
        // for(int i=0; i<tmp; i++){
        //     for(int j=0; j<k; j++){
        //         for(int l=0; l<=(sum/k); l++) dp[i][j][l] = -1;
        //     }
        // }
        
        return solve(nums, sz, k, sum/k, sum/k, 0);
    }

    private boolean solve(int[] nums, int sz, int k, int mT, int target, int cnt){
        if(target == 0){
            cnt++;
            target = mT;
            if(cnt == k){
                boolean flg = true;
                // for(int i : vis) if(i == 0) flg = false;
                // System.out.println("Here at " + cnt + " " + flg + " " + visV + " and " + (Math.pow(2, sz)) );
                return visV == ((int) Math.pow(2, sz)-1);
            }
        }
        List<Integer> key = new ArrayList<>();
        key.add(visV);
        key.add(cnt);
        key.add(target);
        if(dp2.containsKey(key)) return dp2.get(key) == 1;

        boolean tmp = false;
        int V;
        for(int i=0; i<sz; i++){
            V = (int) Math.pow(2, i);
            if(nums[i] <= target && (visV&V) == 0){
                // vis[i] = 1;
                visV += V;
                // System.out.println(cnt + " " + nums[i]);
                tmp = solve(nums, sz, k, mT, target-nums[i], cnt);
                visV -= V;
                if(tmp){
                    // dp[visV][cnt][target] = 1;
                    dp2.put(key, 1);
                    return true;
                } 
                // vis[i] = 0;
            }
        }

        dp2.put(key, 0);
        // dp[visV][cnt][target] = 0;
        return false;
    }
}