class Solution {
    public int longestBalanced(String s) {
        int sz = s.length(), ans = 0;

        for(int i=0; i<sz; i++){
            int f[] = new int[26];
            for(int j=i; j<sz; j++){
                int ind = s.charAt(j) - 'a', mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
                f[ind]++;
                for(int k=0; k<26; k++){
                    if(f[k] == 0) continue;
                    mini = mini < f[k] ? mini : f[k];
                    maxi = maxi > f[k] ? maxi : f[k];
                }
                // System.out.println(i + ":" + j + " " + mini + ":" + maxi);
                if(mini == maxi){
                    ans = ans > (j-i+1) ? ans : (j-i+1);
                }
            }
        }

        return ans;
    }
}