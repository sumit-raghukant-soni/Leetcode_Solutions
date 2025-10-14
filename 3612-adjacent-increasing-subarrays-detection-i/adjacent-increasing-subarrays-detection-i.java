class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int sz = nums.size(), prev = 0, curr, last;

        for(int i=0, j = 0; i<sz; i++, j++){
            // System.out.println(i);
            curr = 0; last = -100000;
            while( i < sz && nums.get(i) > last){
                curr++; 
                last = nums.get(i);
                i++;
            }
            // System.out.println(prev + " " + curr + " " + i);
            if(i != j) i--;
            if(curr >= k*2 || Math.min(prev, curr) >= k) return true;
            prev = curr;
        }

        return false;
    }
}