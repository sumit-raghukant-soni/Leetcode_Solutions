class Solution {
public:
    string clearDigits(string s) {
        deque<char> alpha;
        string ans = "";
        
        for(char ch : s){
            if(ch <= 'z' && ch >= 'a') alpha.push_back(ch);
            else if(!alpha.empty()) alpha.pop_back();
        }

        while(!alpha.empty()){
            ans += alpha.front();
            alpha.pop_front();
        }

        return ans;
    }
};