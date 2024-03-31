class Solution {
public:
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        vector<int> mina, maxa;
        int sz = nums.size();
        long long ans = 0;

        for(int i=0; i<sz; i++){
            if(nums[i] == minK) mina.push_back(i);
            if(nums[i] == maxK) maxa.push_back(i);
        }

        for(int i=0; i<sz; i++){
            if(nums[i] < minK || nums[i] > maxK) continue;
            int l=i;
            while(i<sz && nums[i] >= minK && nums[i] <= maxK) i++;
            i--;
            int last = l-1;
            for(int j=l; j <= i; j++){
                if(nums[j] == minK){
                    int next = lower_bound(maxa.begin(), maxa.end(), j) - maxa.begin();
                    long long cnt1 = j - last;
                    if(next == maxa.size()) continue;
                    long long cnt2 = i - maxa[next]+1;
                    if(cnt2 > 0) ans += (cnt1 * cnt2), last = j;
                }
                else if(nums[j] == maxK){
                    int next = lower_bound(mina.begin(), mina.end(), j) - mina.begin();
                    long long cnt1 = j - last;
                    if(next == mina.size()) continue;
                    long long cnt2 = i - mina[next]+1;
                    if(cnt2 > 0) ans += (cnt1 * cnt2), last = j;
                }
            }
        }

        return ans;
    }
};