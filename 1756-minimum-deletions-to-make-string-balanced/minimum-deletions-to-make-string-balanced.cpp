class Solution {
public:
    int minimumDeletions(string s) {
        int sz = s.length(), ans = INT_MAX;
        vector<int> a(sz, 0), b(sz, 0);
        int lastValue = 0;

        for(int i=0; i<sz; i++){
            if(s[i] == 'b'){
                a[i] = lastValue++;
            }
            else a[i] = lastValue;
        }
        if(lastValue == sz || lastValue == 0) return 0;
        lastValue = 0;

        for(int i=sz-1; i>=0; i--){
            if(s[i] == 'a'){
                b[i] = lastValue++;
            }
            else b[i] = lastValue;
        }

        for(int i=0; i<sz; i++){
            // cout << a[i] << ":" << b[i] << endl;
            ans = min(ans, a[i]+b[i]);
        }

        return ans;
    }
};