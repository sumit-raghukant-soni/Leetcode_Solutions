class Solution {
    public int numRabbits(int[] ans) {
        int sz = ans.length, count = 0;

        Arrays.sort(ans);

        for(int i=0; i<sz; i++){
            int curr = ans[i], j = i, cnt = 0;
            while(j < sz && ans[j] == curr){
                j++; cnt++;
            }
            i = j-1;
            // System.out.println(curr + " " + cnt);
            if(cnt%(curr+1) != 0){
                count += (curr+1) - (cnt%(curr+1));
            }
        }

        return count + sz;
    }
}