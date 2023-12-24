class Solution {
public:
    int minOperations(string s) {
        int odd = 0, even = 0, sz = s.length();

        for(int i=0; i<sz; i++){
            if(i%2 == 0){
                if(s[i] != '0') even++;
                else odd++;
            }
            else{
                if(s[i] != '1') even++;
                else odd++;
            }
        }

        return odd < even ? odd : even;
    }
};