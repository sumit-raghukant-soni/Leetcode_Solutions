class Solution {
public:
    string binaryValue(int num, int mxNum){
        string ans = "";

        while(num){
            int rem = num&1;
            if(rem) ans = "1" + ans;
            else ans = "0" + ans;
            num = num >> 1;
        }

        while(ans.length() < mxNum){
            ans = "0" + ans;
        }

        return ans;
    }
    string findDifferentBinaryString(vector<string>& nums) {
        int sz = nums.size(), ssz = nums[0].size(), mxNum = pow(2, ssz-1);
        unordered_map<int, int> mp;

        for(int i=0; i<sz; i++){
            // cout << stoi(nums[i], nullptr, 2) << endl;
            mp[stoi(nums[i], nullptr, 2)]++;
        }

        for(int i=0; i<=mxNum; i++){
            if(mp.find(i) == mp.end()){
                // cout << i << endl;
                return binaryValue(i, ssz);
            }
        }

        return "";
    }
};