class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int sz = nums.length, ans[] = new int[sz];

        for(int i=0; i<sz; i++){
            int ind = nums[i];
            if(ind < 0){
                ind = (ind*-1)%sz;
                if(ind > i) ind = sz - (ind-i);
                else ind = i - ind;
                // System.out.println(ind);
            }
            else if(ind > 0){
                ind = (ind + i) % sz;
                // System.out.println(ind);
            }
            else ind = i;
            ans[i] = nums[ind];
        }

        return ans;
    }
}