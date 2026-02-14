class Solution {
    public int minRemoval(int[] nums, int k) {
        int sz = nums.length, ans = Integer.MAX_VALUE;
        int arr[] = new int[sz];

        for(int i=0; i<sz; i++) arr[i] = nums[i];
        Arrays.sort(arr);

        for(int i=0; i<sz; i++){
            int ind = check(arr, sz, 1L * arr[i] * k);       
            // System.out.println(arr[i] + " " + ind);
            if(ind != -1){
                ans = ans < (sz - (ind - i + 1)) ? ans : (sz - (ind - i + 1));
            }
        }

        return ans;
    }

    private int check(int[] arr, int sz, long val){
        int s = 0, e = sz-1, ans = -1;

        while(s <= e){
            int mid = s + (e-s)/2;
            if(arr[mid] <= val){
                ans = mid;
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }

        return ans;
    }
}