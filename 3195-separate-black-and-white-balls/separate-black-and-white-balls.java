class Solution {
    public long minimumSteps(String s) {
        long k = 0, ans = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1') k++;
        }

        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == '1'){
                k--;
            }
            else{
                ans += k;
            }
        }

        return ans;
    }
}