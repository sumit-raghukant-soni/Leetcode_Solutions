class Solution {
public:
    int minBitFlips(int start, int goal) {
        int cnt = 0;

        while(start | goal){
            int r1 = (start&1), r2 = (goal&1);
            if(r1 != r2) cnt++;
            start = start >> 1, goal = goal >> 1;
        }

        return cnt;
    }
};