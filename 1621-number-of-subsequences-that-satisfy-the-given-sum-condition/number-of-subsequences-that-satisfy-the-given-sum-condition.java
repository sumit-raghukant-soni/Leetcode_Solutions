class Solution {
    public int numSubseq(int[] nums, int target) {
        int sz = nums.length, MOD = 1000000007, limit, s, e, j, mid;
        long ans = 0, tmp;
        Arrays.sort(nums);
        Map<Integer, Long> mp = new HashMap<>();

        tmp = 1;
        mp.put(0, 1L);
        for(int i=1; i<sz; i++){
            tmp = (tmp<<1)%MOD;
            mp.put(i, tmp);
        }

        System.out.println(mp);

        for(int k=0; k<sz && nums[k] < target; k++){
            limit = target - nums[k]; s = k; e = sz-1; j = 0;
            while(s <= e){
                mid = s + (e-s)/2;
                if(nums[mid] > limit){
                    e = mid-1;
                }
                else{
                    j = j > mid ? j : mid;
                    s = mid + 1;
                }
            }
            if(j < k) continue;
            j -= k;
            
            // tmp = 1;
            // int i=1;
            // while(j > 0){
            //     if(mp.containsKey(j)){
            //         tmp = (tmp * mp.get(j))%MOD;
            //         break;
            //     } 
            //     tmp <<= 1;
            //     tmp %= MOD;

            //     mp.put(i++, tmp);
            //     j--;
            // }
            System.out.println(j);
            ans = (ans + mp.get(j))%MOD;
        }

        return (int) ans;
    }
}