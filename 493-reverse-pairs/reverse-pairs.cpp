#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>

using namespace __gnu_pbds;
class Solution {
public:
    int reversePairs(vector<int>& nums) {
        return countReversePairs(nums.begin(), nums.end());
    }

private:
    typedef tree<int, null_type, less<int>, rb_tree_tag, tree_order_statistics_node_update> ordered_set;

    int countReversePairs(vector<int>::iterator begin, vector<int>::iterator end) {
        if (distance(begin, end) <= 1) {
            return 0;
        }

        auto mid = begin + distance(begin, end) / 2;
        int count = countReversePairs(begin, mid) + countReversePairs(mid, end);

        for (auto i = begin, j = mid; i < mid; ++i) {
            while (j < end && *i > 2LL * (*j)) {  // Use long long to avoid overflow
                ++j;
            }
            count += distance(mid, j);
        }

        inplace_merge(begin, mid, end);

        return count;
    }
};