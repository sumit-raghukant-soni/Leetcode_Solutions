class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int sz1 = s.length(), sz2 = queries.length;
        int freq[][] = new int[sz1][26];
        List<Boolean> ans = new ArrayList<>();

        for(int i=0; i<sz1; i++){
            for(int j=0; i>0 && j<26; j++){
                freq[i][j] = freq[i-1][j];
            }
            freq[i][s.charAt(i) - 'a']++;
            // for(int j=0; j<26; j++){
            //     System.out.print(freq[i][j] + ",");
            // }
            // System.out.println();
        }

        for(int i=0; i<sz2; i++){
            if( valid(freq, queries[i][0], queries[i][1], queries[i][2]) ) ans.add(true);
            else ans.add(false);
        }

        return ans;
    }

    private boolean valid(int[][] freq, int l, int r, int rep){
        int f[] = new int[26], total = 0, k = r - l + 1;
        int extra = 0;
        if((k&1) == 1){
            extra = 1; k--;
        }

        for(int i=0; i<26; i++){
            f[i] = freq[r][i] - (l-1 >= 0 ? freq[l-1][i] : 0);
            total += f[i];
            int tmp = (f[i]&1) == 1 ? f[i]-1 : f[i];
            if(k >= tmp){
                k -= tmp;
                total -= tmp;
            }
            else {
                total -= k;
                k = 0;
            }
            // System.out.println(tmp);
            // System.out.println( ((char) (i + 'a')) + " " + k + ", ");
        }
        // System.out.println();

        // System.out.println("For " + l + ":" + r + ":" + rep + " " + k );
        if((k/2) > rep) return false;
        return true;
    }
}