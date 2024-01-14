class Solution {
public:
    int hIndex(vector<int>& citations) {
        sort(citations.begin(), citations.end());
        int sz = citations.size(), ans=0;

        for(int i=0; i<sz; i++){
            if(citations[i] >= sz-i)
                ans = ans > sz-i ? ans : sz-i;
        }
        
        return ans;
    }
};