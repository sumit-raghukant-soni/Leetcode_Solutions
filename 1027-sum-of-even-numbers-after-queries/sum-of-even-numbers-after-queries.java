class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sz1 = nums.length, sz2 = queries.length;
        int sum = 0, ans[] = new int[sz2];

        for(int i=0; i<sz1; i++){
            if( (nums[i]&1) == 0 ) sum += nums[i];
        }

        for(int i=0; i<sz2; i++){
            int ind = queries[i][1], val = queries[i][0];
            if( (nums[ind]&1) == 0 ) sum -= nums[ind];
            nums[ind] += val;
            if( (nums[ind]&1) == 0 ) sum += nums[ind];
            ans[i] = sum;
        }

        return ans;
    }
}