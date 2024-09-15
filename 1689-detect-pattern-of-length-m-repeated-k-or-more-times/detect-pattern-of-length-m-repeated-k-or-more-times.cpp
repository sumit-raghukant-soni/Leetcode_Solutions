class Solution {
public:

    bool containsPattern(vector<int>& arr, int m, int k) {
        int sz = arr.size();
        vector<int> tmp;
        map<vector<int>, int> mp;

        for(int i=0; i<sz; i++){
            tmp.push_back(arr[i]);
            if(i+1 >= m){
                int cnt = 1;
                for(int j=i+1; j<sz-m+1; j+=m){
                    vector<int> tmp2(arr.begin()+j, arr.begin()+j+m);
                    // for(int h : tmp2) cout << h << ", ";
                    // cout << endl;
                    if(tmp2 == tmp) cnt++;
                    else break;
                }
                mp[tmp] = max(cnt, mp[tmp]);
                tmp.erase(tmp.begin());
            }
        }

        for(auto i : mp){
            // for(int j : i.first) cout << j << ", ";
            // cout << endl;
            // cout << i.second << endl;
            if(i.second >= k) return true;
        }

        return false;
    }
};