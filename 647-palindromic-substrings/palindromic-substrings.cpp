class Solution {
public:
    int countSubstrings(string s) {
        int cnt = 0, sz = s.length(), tcnt = 0;

        for(int i=0; i<sz; i++){
            string tmp = string(1, s[i]), rtmp;
            tcnt = 1;
            for(int j=i+1; j<sz; j++){
                tmp += s[j];
                rtmp = tmp;
                reverse(rtmp.begin(), rtmp.end());
                if(rtmp == tmp){
                    tcnt++;
                }
            }
            cnt += tcnt;
        }

        return cnt;
    }
};