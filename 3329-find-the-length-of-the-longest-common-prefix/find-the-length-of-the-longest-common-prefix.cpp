class Solution {
public:
    int longestCommonPrefix(vector<int>& arr1, vector<int>& arr2) {
        int sz1 = arr1.size(), sz2 = arr2.size(), tmp, ans = 0;
        unordered_map<int, int> mp1, mp2;

        for(int i=0; i<sz1; i++){
            tmp = arr1[i];
            while(tmp){
                mp1[tmp]++;
                tmp /= 10;
            }
        }

        for(int i=0; i<sz2; i++){
            tmp = arr2[i];
            while(tmp){
                mp2[tmp]++;
                tmp /= 10;
            }
        }

        for(auto i : mp1){
            if(mp2.find(i.first) != mp2.end()){
                ans = max(ans, i.first);
            }
        }

        int cnt = 0;
        while(ans){
            cnt++;
            ans/=10;
        }

        return cnt;
    }
};