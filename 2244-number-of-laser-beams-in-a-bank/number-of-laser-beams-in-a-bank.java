class Solution {
    public int numberOfBeams(String[] bank) {
        int m = bank.length, n = bank[0].length();
        int cnt = 0, prev = 0, ans = 0;

        for(int i=0; i<m; i++){
            cnt = 0;
            for(int j=0; j<n; j++){
                if(bank[i].charAt(j) == '1') cnt++;
            }
            // System.out.println(cnt + " " + prev);
            if(cnt > 0){
                ans += cnt * prev;
                prev = cnt;
            }
        }

        return ans;
    }
}