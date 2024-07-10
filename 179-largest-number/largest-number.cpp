class Solution {
public:
    string largestNumber(vector<int>& nums) {
        string ans = "";
        unordered_map<int, int> mp;
        vector<string> tmp;
        for(int i : nums){
            // tmp.push_back(to_string(i));
            mp[i]++;
        }

        for(auto i : mp){
            string t = to_string(i.first);
            string val = "";
            for(int k=0; k<i.second; k++) val += t;
            tmp.push_back(val);
        }

        if(tmp.size() == 1) return tmp[0][0] == '0' ? "0" : tmp[0];

        sort(tmp.begin(), tmp.end(), [](string& a, string& b){
            cout << a << " " << b << endl;
            if(a[0] > b[0]) return true;
            else if(a[0] == b[0]){
                if(a+b < b+a) return false;
                return true;
            }
            return false;
        });

        for(string i : tmp) ans += i;

        return ans[0] == '0' ? "0" : ans;
    }
};