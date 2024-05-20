class Solution {
public:
    vector<string> subdomainVisits(vector<string>& cpdomains) {
        vector<string> ans;
        unordered_map<string, int> mp;
        int sz = cpdomains.size(), cnt;
        string subdomain;

        for(int i=0; i<sz; i++){
            int dsz = cpdomains[i].length(), k=0;
            subdomain = ""; cnt = 0;
            for(;k<dsz; k++){
                if(cpdomains[i][k] == ' ') break;
                cnt = (cnt*10) + int(cpdomains[i][k] - '0');
            }
            for(int j=dsz-1; j>k; j--){
                if(cpdomains[i][j] == '.') mp[subdomain]+= cnt;
                subdomain = cpdomains[i][j] + subdomain;
            }
            mp[subdomain]+= cnt;
        }

        for(auto i : mp){
            ans.push_back(to_string(i.second) + " " + i.first);
        }

        return ans;
    }
};