class Solution {
    public int minOperations(int[] nums) {
        int sz = nums.length, minSz = sz;
        int one = 0, currGcd = 0;

        for(int i : nums){
            if(i == 1) one++;
            currGcd = gcd(currGcd, i);
        }

        if(one > 0) return sz - one;
        if(currGcd > 1) return -1;

        for(int i=0; i<sz; i++){
            currGcd = 0;
            for(int j=i; j<sz; j++){
                currGcd = gcd(currGcd, nums[j]);
                if(currGcd == 1){
                    minSz = minSz > (j-i+1) ? (j-i+1) : minSz;
                    break;
                }
            }
        }

        return minSz + sz - 2;
    }

    private int gcd(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}