class Solution {
    public int longestArithSeqLength(int[] nums) {
        int sz = nums.length, fq[][] = new int[sz][1001];
        int ans = 1;

        for(int i=1; i<sz; i++){
            for(int j=i-1; j>=0; j--){
                int diff = 500 + (nums[i] - nums[j]);
                if(fq[i][diff] == 0) fq[i][diff] = 1 + fq[j][diff];
                // System.out.println(nums[i] + ":" + diff + " " + fq[i][diff]);
                ans = ans > fq[i][diff] ? ans : fq[i][diff];
            }
        }

        return ans + 1;
    }
}