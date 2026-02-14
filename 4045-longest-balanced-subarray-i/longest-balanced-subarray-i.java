class Solution {
    public int longestBalanced(int[] nums) {
        int sz = nums.length, o, e;
        int ans = 0;
        Map<Integer, Integer> f;

        for(int i=0; i<sz; i++){
            // if(ans == sz) break;
            o = e = 0;
            f = new HashMap<>();
            for(int j=i; j<sz; j++){
                if(!f.containsKey(nums[j])){
                   if((nums[j]&1) == 1) o++;
                   else e++;
                }

                f.put( nums[j], f.getOrDefault(nums[j], 0) + 1 );
                // System.out.println(i + " to " + j + " " + o + ":" + e);
                if(o == e) ans = ans > (j-i+1) ? ans : (j-i+1);
            }
        }

        return ans;
    }
}