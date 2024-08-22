class Solution {
public:
    bool isUgly(int n) {
        if(n < 1) return false;

        long val = n;

        while(val != 1){
            if(val%2 == 0) val /= 2;
            else if(val%3 == 0) val /= 3;
            else if(val%5 == 0) val /= 5;
            else return false;
        }

        return true;
    }
};