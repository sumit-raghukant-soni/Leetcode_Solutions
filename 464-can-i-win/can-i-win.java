class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();
    public boolean canIWin(int maxi, int total) {
        if(total == 0) return true;
        if( (maxi*(maxi+1))/2 < total) return false;

        return solve(maxi, total, 0) == 1;
    }

    private int solve(int maxi, int total, int nums){
        if(memo.containsKey(nums)) return memo.get(nums);

        for(int j=1; j<=maxi; j++){
            int curr = 1 << (j-1);
            if((nums & curr) == 0){
                if(j >= total || solve(maxi, total-j, (nums | curr)) == 0){
                    memo.put(nums, 1);
                    return 1;
                }
                
            }
        }

        memo.put(nums, 0);
        return 0;
    }
}