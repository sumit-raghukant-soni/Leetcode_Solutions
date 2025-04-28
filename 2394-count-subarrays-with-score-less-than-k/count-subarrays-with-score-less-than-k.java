class Solution {
    public long countSubarrays(int[] nums, long k) {
        int sz = nums.length;
        long pre[] = new long[sz];
        long ans = 0;

        pre[0] = nums[0];
        for(int i=1; i<sz; i++){
            pre[i] = pre[i-1] + nums[i];
        }

        for(int i=0; i<sz; i++){
            long extra = 0;
            int s = i, e = sz-1, j = -1;
            if(i-1 >= 0) extra = pre[i-1];
            while(s <= e){
                int mid = s + (e-s)/2;
                long tmp = pre[mid] - extra;
                // System.out.println("For " + i + " :: " + mid + " value = " + (tmp*(mid-i+1)) );
                if( (tmp*(mid-i+1)) < k){
                    j = mid;
                    s = mid+1;
                }
                else e = mid-1;
            }
            if(j != -1) ans += j - i + 1;
            // System.out.println("s = " + s + " " + e + " " + j);
            // System.out.println("For " + nums[i] + " " + (j-i+1));
        }

        return ans;
    }
}