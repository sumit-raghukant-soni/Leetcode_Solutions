class Solution {
    public int[] getNoZeroIntegers(int n) {
        int ans[] = new int[2];

        for(int i=1; i<=n/2; i++){
            if(i%10 == 0) continue;
            if(check(i) && check(n-i)){
                ans[0] = i;
                ans[1] = n - i;
                return ans;
            }
        }

        return ans;
    }

    private boolean check(int n){
        while(n > 0){
            if(n%10 == 0) return false;
            n /= 10;
        }
        return true;
    }
}