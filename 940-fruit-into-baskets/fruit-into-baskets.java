class Solution {
    public int totalFruit(int[] fruits) {
        int sz = fruits.length, ans = 0;
        int cnt = 0, j = 0;
        int freq[] = new int[sz];

        for(int i=0; i<sz; i++){
            if(freq[fruits[i]] == 0){
                cnt++;
            }
            freq[fruits[i]]++;
            while(cnt > 2){
                freq[fruits[j]]--;
                if(freq[fruits[j]] == 0) cnt--;
                j++;
            }
            ans = ans > (i-j+1) ? ans : (i-j+1);
        }

        return ans;
    }
}