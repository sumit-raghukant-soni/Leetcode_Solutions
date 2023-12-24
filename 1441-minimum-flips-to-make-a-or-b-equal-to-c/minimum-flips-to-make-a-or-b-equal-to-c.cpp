class Solution {
public:
    int minFlips(int a, int b, int c) {
        int cnt = 0;

        while(a || b || c){
            int r1 = (a&1), r2 = (b&1), r3 = (c&1);
            if(r1 && r2){
                if(!r3) cnt += 2;
            }
            else if((r1 | r2) != r3) cnt += 1;
            a = a >> 1, b = b >> 1, c = c >> 1;
        }

        return cnt;
    }
};