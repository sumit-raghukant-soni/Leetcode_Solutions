class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        vector<int> ans;
        int sz = asteroids.size();
        int i=0, j=sz-1;
        while(i<sz && asteroids[i] < 0) ans.push_back(asteroids[i++]);
        for(; i<sz; i++){
            if(ans.size() == 0 || (ans.back() < 0 && asteroids[i] < 0) 
            || (ans.back() > 0 && asteroids[i] > 0) || (ans.back() < 0 && asteroids[i] > 0)) 
            ans.push_back(asteroids[i]);
            else if(ans.back() > 0 && asteroids[i] < 0){
                while(ans.size() && ans.back() > 0 && ans.back() < asteroids[i]*-1) ans.pop_back();
                if(ans.size() == 0) ans.push_back(asteroids[i]);
                else if(ans.back() == asteroids[i]*-1) ans.pop_back();
                else if(ans.back() < 0 && asteroids[i] < 0) ans.push_back(asteroids[i]);
            }
            // for(auto k : ans) cout << k << " ";
            // cout << endl;
        }

        return ans;
    }
};