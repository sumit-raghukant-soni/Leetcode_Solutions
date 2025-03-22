class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int sz = answerKey.length();
        int sum = 0, ans = 0, k2 = 0, j = 0;

        for(int i=0; i<sz; i++){
            sum++;
            if(answerKey.charAt(i) == 'F') k2++;
            while(k2 > k){
                if(answerKey.charAt(j++) == 'F') k2--;
                sum--;
            }
            ans = Math.max(ans, sum);
        }

        sum = 0; k2 = 0; j = 0;
        for(int i=0; i<sz; i++){
            sum++;
            if(answerKey.charAt(i) == 'T') k2++;
            while(k2 > k){
                if(answerKey.charAt(j++) == 'T') k2--;
                sum--;
            }
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}