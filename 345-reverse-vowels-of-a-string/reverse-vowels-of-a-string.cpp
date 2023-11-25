class Solution {
public:
    string reverseVowels(string s) {
        string ans = s;
        int sz = ans.length();
        int i=0, j=sz-1;
        
        while(i < j){
            while(i<j && (ans[i] != 'a' && ans[i] != 'e' && ans[i] != 'i' && ans[i] != 'o' && ans[i] != 'u') && (ans[i] != 'A' && ans[i] != 'E' && ans[i] != 'I' && ans[i] != 'O' && ans[i] != 'U')){
                i++;
            }
            while(j>i && (ans[j] != 'a' && ans[j] != 'e' && ans[j] != 'i' && ans[j] != 'o' && ans[j] != 'u') && (ans[j] != 'A' && ans[j] != 'E' && ans[j] != 'I' && ans[j] != 'O' && ans[j] != 'U')){
                j--;
            }
            if(i < j) swap(ans[i++], ans[j--]);
        }

        return ans;
    }
};