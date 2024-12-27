class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int sz = values.length, maxi = 0, tmp = 0;
        int a[] = new int[sz], b[] = new int[sz];

        a[sz-1] = values[sz-1]+sz-1;
        b[sz-1] = values[sz-1]-(sz-1);
        tmp = b[sz-1];
        for(int i=sz-2; i>=0; i--){
            a[i] = values[i] + i;
            b[i] = tmp;
            tmp = Math.max(values[i]-i, b[i]);
        }

        for(int i=0; i<sz-1; i++){
            // System.out.println(a[i] + " " + b[i]);
            maxi = Math.max(maxi, a[i] + b[i]);
        }

        return maxi;
    }
}