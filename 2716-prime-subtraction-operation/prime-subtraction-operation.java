class Solution {
    public boolean primeSubOperation(int[] nums) {
        int sz = nums.length, primes[] = new int[1001];
        if(sz == 1) return true;

        for(int i=0; i<1001; i++) primes[i] = 1;

        primes[1] = 0;

        for(int i=2; i<1001; i++){
            if(primes[i] == 1){
                for(int j=i*2; j<1001; j+=i){
                    primes[j] = 0;
                }
            }
        }

        int l=0, h=0;
        for(int i=sz-2; i>=0; i--){
            if(nums[i] >= nums[i+1]){
                l = nums[i] - (nums[i+1] - 1);
                h = nums[i];
                int feasibleValue = -1;
                for(int j=2; j<=1000; j++){
                    if(primes[j] == 1 && l <= j && j < h){
                        feasibleValue = j;
                        break;
                    }
                }
                if(feasibleValue == -1){
                    return false;
                }
                else{
                    nums[i] = nums[i] - feasibleValue;
                }
            }
        }

        return true;
    }
}