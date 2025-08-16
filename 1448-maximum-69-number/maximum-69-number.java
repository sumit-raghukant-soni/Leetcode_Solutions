class Solution {
    public int maximum69Number (int num) {
        int tmp = num, ind = -1, k = 0;

        while(tmp > 0){
            if((tmp%10) == 6) ind = k;
            k++;
            tmp /= 10;
        }

        if(ind != -1) num += (int)( 3 * Math.pow(10, ind));
        return num;
    }
}