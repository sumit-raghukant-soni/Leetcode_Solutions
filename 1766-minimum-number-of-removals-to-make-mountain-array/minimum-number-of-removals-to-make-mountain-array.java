class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int sz = nums.length, ans = 0;
        int left[] = new int[sz], right[] = new int[sz];

        for(int i=0; i<sz; i++){
            int j = i-1, maxi = 0;
            while(j >= 0){
                if(nums[j] < nums[i]) maxi = Math.max(left[j], maxi);
                j--;
            }
            left[i] += maxi+1;
        }

        for(int i=sz-1; i>=0; i--){
            int j = i+1, maxi = 0;
            while(j < sz){
                if(nums[j] < nums[i]) maxi = Math.max(right[j], maxi);
                j++;
            }
            right[i] += maxi+1;
        }

        for(int i=1; i<sz-1; i++){
            // System.out.print(left[i] + " " + right[i] + " , ");
            if(left[i] > 1 && right[i] > 1) ans = Math.max(ans, left[i]+right[i]-2);
        }

        return sz - (ans+1);
    }
}