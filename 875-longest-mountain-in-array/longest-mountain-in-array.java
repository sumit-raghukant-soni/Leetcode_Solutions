class Solution {
    public int longestMountain(int[] arr) {
        int sz = arr.length, ans = 0;
        int pre[] = new int[sz], suf[] = new int[sz];

        for(int i=0; i<sz; i++){
            pre[i] = 1;
            if(i-1 >= 0 && arr[i-1] < arr[i]) pre[i] += pre[i-1];
        }

        for(int i=sz-1; i>=0; i--){
            suf[i] = 1;
            if(i+1 < sz && arr[i+1] < arr[i]) suf[i] += suf[i+1];
        }

        for(int i=1; i<sz-1; i++){
            if(pre[i] > 1 && suf[i] > 1) ans = ans > (pre[i] + suf[i] - 1) ? ans : (pre[i] + suf[i] - 1);
        }

        return ans;
    }
}