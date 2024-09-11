class Solution {
public:
    int minBitFlips(int start, int goal) {
        int cnt = 0, k=1;

        while(k < 32){
            int a = start&1, b = goal&1;
            start = start >> 1, goal = goal >> 1;
            if(a != b) cnt++;
            k++;
        }

        return cnt;
    }
};