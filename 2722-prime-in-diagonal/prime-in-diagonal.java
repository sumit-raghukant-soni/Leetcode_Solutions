class Solution {
    public int diagonalPrime(int[][] nums) {
        int[] primes = new int[4000001];

        for(int i=2; i<4000001; i++){
            if(primes[i] == -1) continue;
            primes[i] = 1;
            for(int j=i*2; j<4000001; j+=i){
                primes[j] = -1;
            }
        }

        int row = nums.length, col = nums[0].length, ans = 0;
        for(int i=0; i<row; i++){
            if(primes[nums[i][i]] == 1){
                ans = Math.max(ans, nums[i][i]);
            }
            if(primes[nums[i][col-1-i]] == 1){
                ans = Math.max(ans, nums[i][col-1-i]);
            }
        }

        return ans;
    }
}