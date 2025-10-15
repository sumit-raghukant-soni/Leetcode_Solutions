class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int sz = nums.size();
        int curr, prev = -1, ans = 0, val;

        for(int i=0, j=0; i<sz; i++, j++){
            val = Integer.MIN_VALUE; curr = 0;
            while(i < sz && nums.get(i) > val){
                val = nums.get(i); i++; curr++;
            }
            if(i != j) i--;
            // System.out.println(prev + " " + curr + " " + i);
            ans = ans > Math.min(curr, prev) ? ans : Math.min(curr, prev);
            ans = ans > curr/2 ? ans : curr/2;
            prev = curr;
        }

        return ans;
    }
}