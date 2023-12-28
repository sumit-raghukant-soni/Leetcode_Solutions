class Solution {
public:
    long long int solve(vector<int>& piles, int sz, int k){
        long long int cnt = 0;
        for(int i=0; i<sz; i++){
            cnt += piles[i]/k;
            if(piles[i]%k > 0) cnt++;
        }
        return cnt;
    }
    int minEatingSpeed(vector<int>& piles, int h) {
        int sz = piles.size();

        long long int s = 1, e = *max_element(piles.begin(), piles.end());
        long long int mid, ans = INT_MAX;
        while(s <= e){
            mid = s + (e-s)/2; 
            long long int cnt = solve(piles, sz, mid);
            // cout << s << " " << e << " " << cnt << " " << mid << endl;
            if(cnt <= h) ans = min(ans, mid);
            if(cnt > h)
                s = mid + 1;
            else
                e = mid - 1;
        }

        return ans;
    }
};