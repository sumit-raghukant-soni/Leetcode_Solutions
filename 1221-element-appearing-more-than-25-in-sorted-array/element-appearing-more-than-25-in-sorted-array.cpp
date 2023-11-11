class Solution {
public:
    int findSpecialInteger(vector<int>& arr) {
        int sz = arr.size();
        if(sz == 1) return arr[0];
        int cnt, k = sz/4;

        for(int i=0; i<sz;){
            int tmp = arr[i];
            i++;
            cnt = 0;
            while(i<sz && arr[i] == tmp){
                i++;
                cnt++;
                if(cnt >= k) return tmp;
            }
        }

        return -1;
    }
};