class Solution {
public:
    int minimumBoxes(vector<int>& apple, vector<int>& capacity) {
        int total = accumulate(apple.begin(), apple.end(), 0), sz = capacity.size();
        sort(capacity.begin(), capacity.end(), greater<int>());

        for(int i=0; i<sz; i++){
            if(total > 0) total -= capacity[i];
            else return i;
        }

        return sz;
    }
};