class Solution {
public:
    long long makePalindrome(int val, int length){
        long long ans = val;
        if(length&1) val/=10;
        
        while(val){
            ans = (ans*10) + val%10;
            val /= 10;
        }

        return ans;
    }
    vector<long long> kthPalindrome(vector<int>& queries, int intLength) {
        int half = intLength/2;
        long long val = pow(10, intLength&1 ? half : half-1);
        int sz = queries.size();
        vector<long long> ans;
        // cout << val << " " << half << endl;
        long long maxi = 1, tmpMaxi = (val * 10.0 * (10.0/9.0));

        for(int i=0; i<intLength; i++) maxi *= 10;

        for(int i=0; i<sz; i++){
            long long tmp = val + (queries[i] - 1);
            if(tmp > tmpMaxi) ans.push_back(-1);
            else{
                long long v = makePalindrome(tmp, intLength);
                if(v <= maxi) ans.push_back(v);
                else ans.push_back(-1);
            }
        }

        return ans;
    }
};