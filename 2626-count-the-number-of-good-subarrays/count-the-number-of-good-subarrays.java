class Solution {
    public long countGood(int[] nums, int k) {
        int sz = nums.length, cnt = 0, j = 0;
        long ans = 0L;
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i=0; i<sz; i++){
            if( freq.containsKey(nums[i]) ){
                cnt += freq.get(nums[i]);
                freq.put(nums[i], freq.get(nums[i]) + 1);
            }
            else{
                freq.put(nums[i], 1);
            }
            // System.out.println(cnt);
            if(cnt >= k){
                while(j < i && (cnt-(freq.get(nums[j])-1)) >= k){
                    freq.put(nums[j], freq.get(nums[j]) - 1);
                    cnt -= freq.get(nums[j]);
                    // System.out.println("deleted " + j + " so, cnt = " + cnt);
                    j++;
                }
                ans += j+1;
            }
        }

        return ans;
    }
}