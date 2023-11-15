class Solution {
public:
    int maxPower(string s) {
        int ans = 0;
        int sz = s.length();
        int ind, i;
        for(i=0; i<sz; i++){
            ind = i;
            while(i+1<sz && s[i+1] == s[ind])
                i++;
            
            if(ind != i){
                ans = max(ans, i - ind + 1);
                i--;
            }
        }

        if(ind != i)
            ans = max(ans, i - ind);

        return ans;
    }
};