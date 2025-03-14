class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int sz = queries.length, s = -1, e = sz-1;
        int ans = Integer.MAX_VALUE;

        while(s <= e){
            int mid = s + (e-s)/2;
            boolean chk = check(nums, queries, mid);
            if(chk){
                ans = mid+1;
                e = mid - 1;
            }
            else s = mid + 1;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private boolean check(int[] nums, int[][] queries, int mid){
        int sz1 = nums.length, sz2 = queries.length;
        int s, e, val;
        long sum = 0;
        int[] updatesArr = new int[sz1+1];

        if(mid != -1){
            for(int i=0; i<=mid; i++){
                s = queries[i][0]; e = queries[i][1]; val = queries[i][2];
                updatesArr[s] += val;
                updatesArr[e+1] -= val;
            }
        }

        // System.out.println(mid);
        for(int i=0; i<sz1; i++){
            sum += updatesArr[i];
            // System.out.print(sum + ":" + nums[i] + ", ");
            if(sum < nums[i]) return false;
        }
        // System.out.println();

        return true;
    }
}