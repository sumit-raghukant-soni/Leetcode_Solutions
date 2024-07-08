class Solution {
public:
    int findTheWinner(int n, int k) {
        queue<int> q;
        for(int i=1; i<=n; i++) q.push(i);
        
        int k2 = 1;
        while(q.size() > 1){
            int tmp = q.front();
            q.pop();
            if(k2 < k){
                q.push(tmp);
                k2++;
            }
            else k2 = 1;
        }

        return q.front();
    }
};