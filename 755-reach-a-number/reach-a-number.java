class Solution {
    public int reachNumber(int target) {
        target = target < 0 ? target*-1 : target;
        int  stp = 0, sum = 0;

        while(sum < target){
            stp++;
            sum += stp;
        }

        while( ((sum - target)&1) != 0 ){
            stp++;
            sum += stp;
        }

        return stp;
    }
}