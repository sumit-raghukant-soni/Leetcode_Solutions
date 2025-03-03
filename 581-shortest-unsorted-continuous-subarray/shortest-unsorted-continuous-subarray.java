class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int sz = nums.length;
        int s = -1, e = -1;
        int[] arr = new int[sz];

        for(int i=0; i<sz; i++) arr[i] = nums[i];
        Arrays.sort(arr);

        for(int i=0; i<sz; i++){
            if(arr[i] != nums[i]){
                s = i;
                 break;
            }
        }

        for(int i=sz-1; i>=0; i--){
            if(arr[i] != nums[i]){
                e = i;
                break;
            }
        }

        if(s == -1) return 0;
        return (e-s) + 1;
    }
}