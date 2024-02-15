class Solution {
public:
    bool isPalindrome(int x) {
        if(x < 0) return false;
        long long tmp = x, rev = 0;
        while(tmp > 0){
            int rem = tmp%10;
            rev = (rev*10) + rem;
            tmp /= 10;
        }
        return x == rev;
    }
};