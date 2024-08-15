class Solution {
public:
    
    vector<int> grayCode(int n) {
        int sz = pow(2, n), i=1;
        vector<int> ans;
        unordered_map<int, int> mp;
        mp[0]++;
        ans.push_back(0);
        int graycode = 0;

        while(ans.size() < sz){
            int changedMSB = graycode ^ 1, k=1;
            if(changedMSB == 0) changedMSB = graycode;
            // cout << "initial " << changedMSB << " = ";
            while(mp.find(changedMSB) != mp.end()){
                k *= 2;
                changedMSB = graycode ^ k;
                // cout << "u " << changedMSB << ", ";
                if(changedMSB == 0) break;
            }
            // cout << endl;
            k *= 2;
            if(changedMSB == 0) changedMSB = graycode | k;
            // cout << "final " << changedMSB << " " << k << endl;
            mp[changedMSB]++;
            ans.push_back(changedMSB);
            graycode = changedMSB;
        }


        return ans;
    }
};