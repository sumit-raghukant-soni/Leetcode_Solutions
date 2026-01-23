class Solution {
    public int[] numMovesStonesII(int[] stones) {
        int sz = stones.length, i=0;

        int arr[] = new int[sz], ans[] = new int[2];
        for(i=0; i<sz; i++) arr[i] = stones[i];

        Arrays.sort(arr);
        
        ans[0] = sz; i = 0;
        for(int j=0; j<sz; j++){
            while(arr[j] - arr[i] + 1 > sz){
                i++;
            }

            int cnt = j - i + 1;
            if(cnt == sz-1 && arr[j] - arr[i] == sz-2){
                ans[0] = ans[0] < 2 ? ans[0] : 2;
            }
            else {
                ans[0] = ans[0] < (sz - cnt) ? ans[0] : (sz - cnt);
            }
        }

        ans[1] = Math.max(
            arr[sz-1] - arr[1] - (sz-2),
            arr[sz-2] - arr[0] - (sz-2)
        );

        return ans;
    }
}