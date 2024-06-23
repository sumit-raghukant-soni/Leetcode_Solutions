class Solution {
public:
    vector<int> getMax(vector<int>& nums, int k){
        if(k == 0) return {};
        int sz = nums.size();
        vector<int> res;

        for(int i=0; i<sz; i++){
            while(!res.empty() && nums[i] > res.back() && (k-res.size()) <= sz - i - 1){
                res.pop_back();
            }
            if(res.size() < k) res.push_back(nums[i]);
        }
        return res;
    }
    bool findGreater(vector<int>& nums1, vector<int>& nums2, int a, int b){
        int sz1 = nums1.size(), sz2 = nums2.size();

        while(a < sz1 || b < sz2){
            if(a >= sz1) return false;
            else if(b >= sz2) return true;
            else if(nums1[a] < nums2[b]) return false;
            else if(nums1[a] > nums2[b]) return true;
            else a++, b++;
        }
        return true;
    }
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        int sz1 = nums1.size(), sz2 = nums2.size();
        vector<int> ans(k, 0);

        for(int i=0; i<=k; i++){
            int j=k-i;
            if(i > sz1 || j > sz2) continue;
            vector<int> max1 = getMax(nums1, i);
            vector<int> max2 = getMax(nums2, j);
            vector<int> merged;
            int a = 0, b = 0;
            // for(int l : max1) cout << l << " ";
            // cout << endl;
            // for(int l : max2) cout << l << " ";
            // cout << endl;
            while(a < (i) || b < (j)){
                if(a >= (i)) merged.push_back(max2[b++]);
                else if(b >= (j)) merged.push_back(max1[a++]);
                else if(max1[a] < max2[b]) merged.push_back(max2[b++]);
                else if(max1[a] > max2[b]) merged.push_back(max1[a++]);
                else {
                    if(findGreater(max1, max2, a, b)) merged.push_back(max1[a++]);
                    else merged.push_back(max2[b++]);
                }
            }
            ans = merged > ans ? merged : ans;
        }

        return ans;
    }
};