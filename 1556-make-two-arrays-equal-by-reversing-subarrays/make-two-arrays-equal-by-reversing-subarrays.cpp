class Solution {
public:
    bool canBeEqual(vector<int>& target, vector<int>& arr) {
        vector<int> tmp = arr, tmp2 = target;
        sort(tmp.begin(), tmp.end());
        sort(tmp2.begin(), tmp2.end());
        return tmp == tmp2;
    }
};