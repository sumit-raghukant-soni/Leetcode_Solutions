class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        int cnt = 0, carry = 0;

        while(numBottles){
            cnt += numBottles;
            numBottles += carry;
            carry = numBottles%numExchange;
            numBottles/=numExchange;
        }

        return cnt;
    }
};