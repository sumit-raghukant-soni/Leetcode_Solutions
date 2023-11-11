class Solution {
public:
    vector<int> mostVisited(int n, vector<int>& rounds) {
        vector<int> arr(n+1, 0);
        vector<int> ans;
        int sz = rounds.size();
        int prev = -1;
        for(int i=0; i<sz-1; i++){
            int tmp = rounds[i];
            while(true){
                if(prev != tmp) arr[tmp]++;
                prev = tmp;
                if(tmp == rounds[i+1]) break;
                tmp++;
                if(tmp > n) tmp = 1;
            }
            cout << endl;
        }

        int maxi = *max_element(arr.begin(), arr.end());
        for(int i=0; i<n+1; i++){
            if(arr[i] == maxi) ans.push_back(i);
        }
        return ans;
    }
};