class Solution {
public:
    int minimumPushes(string word) {
        vector<int> freq(26);
        vector<vector<int>> tmp = {{1,8}, {2,8}, {3,8}, {4, 2}};
        multiset<int> st;
        int ans = 0;

        for(auto i : tmp){
            for(int j=1; j<=i[1]; j++){
                st.insert(i[0]);
            }
        }
        
        for(char ch : word) freq[ch - 'a']++;
        sort(freq.begin(), freq.end(), greater<int>());

        for(int i=0; i<26 && freq[i] != 0; i++){
            ans += freq[i] * (*st.begin());
            st.erase(st.begin());
        }

        return ans;
    }
};