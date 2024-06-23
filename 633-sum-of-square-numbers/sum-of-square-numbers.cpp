class Solution {
public:
    bool judgeSquareSum(int c) {
        int s = 0, e = sqrt(c);
        long long sum = 0;

        while(s <= e){
            sum = (1LL*s*s) + (1LL*e*e);
            if(sum > c) e--;
            else if(sum < c) s++;
            else return true;
        }

        return false;
    }
};