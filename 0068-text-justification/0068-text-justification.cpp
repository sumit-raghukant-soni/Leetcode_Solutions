class Solution {
public:
    string update(vector<string>& lt, int spaces){
        int odd = 0;
        if(lt.size() != 1) odd = spaces%(lt.size()-1);
        int eachSpace;
        if(lt.size() > 1){
            eachSpace = (spaces - odd)/(lt.size()-1);
        }
        else eachSpace = spaces;
        string ans = "";
        for(int i=0; i<lt.size(); i++){
            ans += lt[i];
            if(i != lt.size()-1 || lt.size() == 1){
                if(odd > 0){
                    ans+= " ";
                    odd--;
                }
                for(int j=0; j<eachSpace; j++)
                    ans += " ";
            }
        }
        return ans;
    }
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        if(maxWidth == 1) return words;
        vector<string> ans;
        int tmp = 0,cnt=0;
        vector<string> lt;
        for(int i=0; i<words.size(); i++){
            if(tmp == 0) tmp = words[i].size();
            else{
                tmp += words[i].size();
                cnt++;
            }
            lt.push_back(words[i]);
            if(tmp+cnt-1 >= maxWidth){
                lt.pop_back();
                tmp -= words[i].size();
                ans.push_back(update(lt, maxWidth-tmp));
                lt.clear();
                i--;
                tmp=0,cnt=0;
            }
            if(tmp == maxWidth-1){
                ans.push_back(update(lt, maxWidth-tmp));
                lt.clear();
                tmp=0;
                cnt=0;
            }
        }
        if(lt.size() != 0){
            string ll = "";
        for(int i=0; i<lt.size(); i++){
            ll+= lt[i];
            if(i != lt.size()-1) ll += " ";
        }
        int size = maxWidth - ll.length();
        for(int i=0; i<size; i++){
            ll+= " ";
        }
        ans.push_back(ll);
        }
        return ans;
    }
};