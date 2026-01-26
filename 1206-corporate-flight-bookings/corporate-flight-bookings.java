class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int sz = bookings.length;
        int freq[] = new int[n];
        
        for(int i=0; i<sz; i++){
            int s = bookings[i][0], e = bookings[i][1], val = bookings[i][2];
            freq[s-1] += val;
            if(e < n) freq[e] -= val;
        }

        for(int i=0; i<n; i++){
            if(i > 0) freq[i] += freq[i-1];
        }

        return freq;
    }
}