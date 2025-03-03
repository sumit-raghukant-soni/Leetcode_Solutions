class Solution {
    public int minIncrementForUnique(int[] nums) {
        int sz = nums.length, ans = 0, maxi = 0;
        Arrays.sort(nums);
        SortedSet<Integer> st = new TreeSet<>();
        Map<Integer, Integer> mp = new HashMap<>();
        // System.out.println(sz);

        for(int i=0; i<sz; i++){
            // System.out.print(nums[i] + ",");
            if(i > 0){
                for(int j=nums[i-1]+1; j<nums[i]; j++) st.add(j);
            }
            maxi = Math.max(maxi, nums[i]);
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        
        maxi++;
        // System.out.println();

        for(int i=0; i<sz; i++){
            if(mp.get(nums[i]) > 1){
                mp.put(nums[i], mp.get(nums[i])-1);
                while(!st.isEmpty() && st.first() < nums[i]) st.remove(st.first());
                if(!st.isEmpty()){
                    ans += st.first()-nums[i];
                    nums[i] = st.first();
                    st.remove(st.first());
                }
                else{
                    ans += maxi-nums[i];
                    nums[i] = maxi;
                    maxi++;
                }
            }
            // System.out.print(nums[i] + ",");
        }

        return ans;
    }
}