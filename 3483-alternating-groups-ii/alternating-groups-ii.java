class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int sz = colors.length, ans = 0;
        int first = colors[0], cnt = 1;
        for(int i=1; i<(sz+k-1); i++){
            if(colors[i%sz] != first){
                first = first == 1 ? 0 : 1;
                cnt++;
            }
            else cnt = 1;
            if(i >= (k-1) && cnt >= k){
                ans++;
            }
        }

        return ans;
    }
}