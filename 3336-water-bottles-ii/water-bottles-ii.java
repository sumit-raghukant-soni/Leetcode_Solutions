class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = 0;

        while(numBottles >= numExchange){
            ans += numExchange;
            numBottles++;
            numBottles -= numExchange++;
        }

        return ans + numBottles;
    }
}