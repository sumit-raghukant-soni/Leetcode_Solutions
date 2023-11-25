class Solution {
public:
    int compress(vector<char>& chars) {
        int sz = chars.size();

        vector<char> ans;
        for(int i=0; i<sz; i++){
            char ch = chars[i];
            int cnt = 0, j = i;
            while(j < sz && ch == chars[j]){
                j++, cnt++;
            }
            i = j-1;
            ans.push_back(ch);
            if(cnt == 1) continue;
            int sz1 = ans.size();
            while(cnt > 0){
                ans.insert(ans.begin()+sz1, char('0'+(cnt%10)));
                cnt /= 10;
            }
        }

        chars = ans;
        return ans.size();
    }
};