class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sz = nums.length, ans = 0, sum = 0, j = 0;
        Set<Integer> st = new HashSet<>();

        for(int i=0; i<sz; i++){
            if(st.contains(nums[i])){
                while(j < i && nums[j] != nums[i]){
                    st.remove(nums[j]);
                    sum-=nums[j];
                    j++;
                }
                j++;
                sum -= nums[i];
            }
            st.add(nums[i]);
            sum += nums[i];
            ans = ans > sum ? ans : sum;
        }

        return ans;
    }
}