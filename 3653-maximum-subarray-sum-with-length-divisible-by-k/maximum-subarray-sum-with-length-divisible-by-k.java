class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long ans = Long.MIN_VALUE, sum = 0;
        long arr[] = new long[n];

        for(int i=0; i<n; i++){
            sum += nums[i];
            if(k != 1 && i >= k-1){
                if(i >= k) sum -= nums[i-k];
                ans = Math.max(ans, sum);
            }
            else if(k == 1) {
                if(i > 0) sum -= nums[i-1];
                ans = Math.max(ans, sum);
            }
            arr[i] = sum;
            // System.out.println("Sum " + sum);
            if(i >= (2*k)-1){
                // System.out.println("Here" + sum + " " + arr[i-k]);
                arr[i] = Math.max(sum, sum + arr[i-k]);
                ans = Math.max(ans, arr[i]);
            }
        }

        // for(long i : arr) System.out.print(i + ",");
        // System.out.println();

        return ans;
    }
}