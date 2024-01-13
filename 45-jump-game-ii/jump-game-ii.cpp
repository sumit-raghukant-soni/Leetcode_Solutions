class Solution {
public:
    int jump(vector<int>& nums) {
        int sz = nums.size(), cnt = 1;
        if(sz == 1) return 0;
        deque<int> q;
        q.push_front(nums[0]);
        // cout << sz << endl;
        for(int i=1; i<sz; i++){
            // cout << nums[i] << " " << q.front() << " " << cnt << endl;
            if(!q.empty() && q.front() < i){
                while(!q.empty() && q.front() < i){
                    q.pop_front();
                }
                cnt++;
            }
            while(q.size() > 1 && q.back() < i + nums[i]){
                q.pop_back();
            }
            q.push_back(i + nums[i]);
        }

        return cnt;
    }
};