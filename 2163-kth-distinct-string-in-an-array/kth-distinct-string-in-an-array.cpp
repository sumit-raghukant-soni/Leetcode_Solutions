class Solution {
public:
    string kthDistinct(vector<string>& arr, int k) {
        int sz = arr.size(), tmpK = k;
        unordered_map<string, int> mp;

        for(int i=0; i<sz; i++) mp[arr[i]]++;

        for(int i=0; i<sz; i++){
            if(mp[arr[i]] == 1) tmpK--;
            if(tmpK == 0) return arr[i];
        }   

        return "";
    }
};