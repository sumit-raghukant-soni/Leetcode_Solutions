class Solution {
public:
    int hIndex(vector<int>& citations) {
        int ans = 0, sz = citations.size();

        for(int i=0; i<sz; i++){
            if(citations[i] >= sz-i)
                ans = ans > sz-i ? ans : sz-i;
        }

        return ans;
    }
};