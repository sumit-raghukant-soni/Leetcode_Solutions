class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int sz = nums.length, sz2 = queries.length, pre = 0;
        boolean ans[] = new boolean[sz2];
        int dp[] = new int[sz];

        for(int i=0; i<sz; i++){
            if(i+1 < sz){
                if((nums[i]%2 == 0 && nums[i+1]%2 != 0) || (nums[i]%2 != 0 && nums[i+1]%2 == 0)){
                    dp[i] = pre + 1;
                }
                else{
                    dp[i] = pre;
                }   
            }
            else dp[i] = pre;
            pre = dp[i];
        }

        // for(int i=0; i<sz; i++){
        //     System.out.print(dp[i] + " ");
        // }
        // System.out.println();

        for(int i=0; i<sz2; i++){
            int p = queries[i][0], l = queries[i][1];
            if(p-1 < 0) p = 0;
            else p = dp[p-1];
            if(l-1 < 0) l = 0;
            else l = dp[l-1];
            // System.out.println(l + " " + p);
            if(l - p != (queries[i][1]-queries[i][0])) ans[i] = false;
            else ans[i] = true;
        }

        return ans;
    }
}