class Solution {
public:
    vector<int> findThePrefixCommonArray(vector<int>& A, vector<int>& B) {
        int asz = A.size(), bsz = B.size(), msz = max(bsz, asz), cnt;
        vector<int> ans(msz, 0);
        unordered_map<int, int> amp, bmp;

        for(int i=0; i<msz; i++){
            int a = (i < asz ? A[i] : INT_MAX), b = (i < bsz ? B[i] : INT_MAX);
            if(a != INT_MAX) amp[a]++;
            if(b != INT_MAX) bmp[b]++;
            cnt = 0;
            for(auto j : amp){
                if(bmp.find(j.first) != bmp.end()){
                    cnt += min(j.second, bmp[j.first]);
                }
            }
            ans[i] = cnt;
        }

        return ans;
    }
};