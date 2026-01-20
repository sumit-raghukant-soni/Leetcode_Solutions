class Solution {
    public int maxDistToClosest(int[] seats) {
        int sz = seats.length, ans = 1, last = 0;

        for(int i=0; i<sz; i++) {
            if(seats[i] == 1) {
                if(last == 0) {
                    ans = ans > (i - last) ? ans : (i - last);
                }
                else {
                    ans = ans > (i - last + 1)/2 ? ans : (i - last + 1)/2;
                }
                last = i+1;
            }
        }
        
        ans = ans > (sz - last) ? ans : (sz - last);

        return ans;
    }
}