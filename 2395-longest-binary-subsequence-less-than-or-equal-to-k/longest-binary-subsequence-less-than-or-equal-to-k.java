class Solution {
    public int longestSubsequence(String s, int k) {
        int sz = s.length(), j = sz-1;
        long cnt = 0, val = 0, valCnt = 0, ans = 0;

        for(int i=0; i<sz; i++){
            if(s.charAt(i) == '0'){
                ans++;
                valCnt++;
            }
        }

        for(int i=sz-1; i>=0; i--){
            if(s.charAt(i) == '0'){
                cnt++;
            }
            else{
                val += (int) Math.pow(2, cnt);
                if(val <= k){
                    valCnt++;
                    cnt++;
                }
                else{
                    while(val > k && j >= i){
                        if(s.charAt(j) == '1') val--;
                        val /= 2;
                        j--;
                        valCnt--;
                    }
                }
            }
            ans = Math.max(ans, valCnt);
        }

        return (int) ans;
    }
}