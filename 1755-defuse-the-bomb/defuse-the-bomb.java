class Solution {
    public int[] decrypt(int[] code, int k) {
        int sz = code.length, ans[] = new int[sz], diff = k < 0 ? k*-1 : k, sum = 0;
        if(k == 0){
            return ans;
        }

        if(k > 0){
            for(int i=0; i<sz+k; i++){
                sum += code[i%sz];
                if(i >= diff){
                    ans[i-k] = sum - code[i-k];
                    sum -= code[i-k];
                }
            }
        }
        else{
            for(int i=sz-1; i>=k; i--){
                sum += code[i + (i < 0 ? sz : 0)];
                if(i < sz - diff){
                    ans[i+diff] = sum - code[i+diff];
                    sum -= code[i+diff];
                }
            }
        }

        return ans;
    }
}