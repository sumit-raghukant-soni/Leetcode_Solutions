class Solution {
public:
    int minBitFlips(int start, int goal) {
        int cnt = 0;

        while(start | goal){
            if((start&1) != (goal&1)) cnt++;
            start = start >> 1, goal = goal >> 1;
        }

        return cnt;
    }
};