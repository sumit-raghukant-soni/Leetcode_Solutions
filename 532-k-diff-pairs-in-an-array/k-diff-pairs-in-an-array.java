class Solution {
    public int findPairs(int[] nums, int k) {
        int sz = nums.length, ans = 0;
        HashSet<Integer> st = new HashSet<>(), used = new HashSet<>();

        Arrays.sort(nums);

        for(int i=0; i<sz; i++){
            if(st.contains(nums[i] - k) && !used.contains(nums[i])){
                used.add(nums[i]);
                ans++;
            }
            st.add(nums[i]);    
        }

        return ans;
    }
}