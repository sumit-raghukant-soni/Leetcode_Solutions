class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int sz = nums.size();
        int ans[] = new int[sz];

        for(int i=0; i<sz; i++){
            int val = -1;
            for(int j=0; j<32; j++){
                // System.out.println(nums.get(i) + " " + (1<<j));
                if( (nums.get(i)&(1<<j)) == 0) break;
                val = nums.get(i) - (1<<j);
            }
            if(val > 0) ans[i] = val;
            else ans[i] = -1;
        }

        return ans;
    }
}