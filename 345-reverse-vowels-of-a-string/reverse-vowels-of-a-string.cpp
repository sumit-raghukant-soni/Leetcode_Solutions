class Solution {
public:
    string reverseVowels(string s) {
        string ans = s;
        int sz = ans.length();
        int i=0, j=sz-1;
        
        while(i < j){
            char ch = ans[i];
            while(i<j && (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') && (ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U')){
                i++;
                ch = ans[i];
            }
            ch = ans[j];
            while(j>i && (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') && (ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U')){
                j--;
                ch = ans[j];
            }
            if(i < j) swap(ans[i++], ans[j--]);
        }

        return ans;
    }
};