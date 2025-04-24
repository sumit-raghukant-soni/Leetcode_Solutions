class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int sz = nums.length, ans = 0, elems = 0, curr = 0, j = 0;
        int mp[] = new int[2001];

        for(int i=0; i<sz; i++){
            if(mp[nums[i]] == 0) elems++;
            mp[nums[i]]++;
        }

        Arrays.fill(mp, 0);

        for(int i=0; i<sz; i++){
            if(mp[nums[i]] == 0) curr++;
            mp[nums[i]]++;
            while(elems == curr && mp[nums[j]] != 1){
                mp[nums[j++]]--;
            }
            if(elems == curr) ans += j + 1;
            // System.out.println(ans);
        }

        return ans;
    }
}