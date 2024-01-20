class Solution {
public:
    void addStr(vector<string>& words, vector<string>& ans, int tmp, int pre, int curr, int cnt, int maxWidth){
        int totalSpace = (maxWidth - (tmp - cnt+1));
        int ExtraSpace = cnt-1 > 0 ? totalSpace%(cnt-1) : 0;
        int eachSpace = cnt-1 > 0 ? totalSpace/(cnt-1) : (maxWidth - (tmp-(cnt-1)));
        string str = "";
        for(int i=pre; i<curr; i++){
            str += words[i];
            for(int j=0; j<eachSpace + (ExtraSpace > 0 ? 1 : 0) && totalSpace > 0; j++) str += " ";
            totalSpace -= eachSpace + (ExtraSpace > 0 ? 1 : 0);
            ExtraSpace = ExtraSpace > 0 ? ExtraSpace-1 : 0;
        }
        ans.push_back(str);
    }
    void lastLine(vector<string>& words, vector<string>& ans, int tmp, int pre, int curr, int cnt, int maxWidth){
        int totalSpace = (maxWidth - (tmp - cnt+1));
        string str = "";
        for(int i=pre; i<curr; i++){
            if(str != ""){
                totalSpace--;
                str += " ";
            }
            str += words[i];
        }
        for(int j=0; j<totalSpace; j++) str += " ";
        ans.push_back(str);
    }
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        vector<string> ans;
        int sz = words.size();
        int cnt = 0, space = 0;
        int tmp = 0, pre = 0;
        for(int i=0; i<sz; i++){
            if(tmp + words[i].length() < maxWidth){
                if(tmp != 0) tmp++;
                tmp += words[i].length();
                cnt++;
            }
            else{
                if(tmp > 0) addStr(words, ans, tmp, pre, i, cnt, maxWidth);
                tmp = words[i].length();
                cnt = 1;
                pre = i;
            }
        }

        if(tmp != 0) lastLine(words, ans, tmp, pre, sz, cnt, maxWidth);

        return ans;
    }
};