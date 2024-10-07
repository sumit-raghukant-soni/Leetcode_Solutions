class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sz = timeSeries.length;
        int cnt = 0, curr = -1, next = -1;

        for(int i=0; i<sz; i++){
            curr = timeSeries[i];
            next = curr + duration - 1;
            if(i == sz-1 || (i+1 < sz && next < timeSeries[i+1])){
                cnt += next - curr + 1;
            }
            else{
                cnt += timeSeries[i+1] - curr;
            }
        }

        return cnt;
    }
}