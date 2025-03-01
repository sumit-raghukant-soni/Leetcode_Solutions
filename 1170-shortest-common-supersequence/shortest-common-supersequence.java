class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int sz1 = str1.length(), sz2 = str2.length();
        if(sz1 == 0) return str2;
        if(sz2 == 0) return str1;
        if(sz1 == 0 && sz2 == 0) return "";
        int dp[][] = new int[sz1][sz2];

        int a, b;
        for(int i=0; i<sz1; i++){
            for(int j=0; j<sz2; j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j]++;
                    if(i-1 >= 0 && j-1 >= 0) dp[i][j] += dp[i-1][j-1];
                }
                else{
                    a = i-1 >= 0 ? dp[i-1][j] : 0; b = j-1 >= 0 ? dp[i][j-1] : 0;
                    dp[i][j] = Math.max(a, b);
                }
            }
        }

        // System.out.println(dp[sz1-1][sz2-1]);

        String ans = "";
        int i = sz1-1, j = sz2-1;
        while(i-1 >= 0 && dp[i][j] == dp[i-1][j]){
            ans = str1.charAt(i) + ans;
            i--;
        }

        String inter = "";
        int lasti = 0, lastj = 0;
        while(i >= 0 && j >= 0){
            if(j-1 >= 0 && dp[i][j] == dp[i][j-1]){
                ans = str2.charAt(j) + ans;
                j--;
                // if(dp[i][j] == 0) ans = str1.charAt(i) + ans;
            }
            else if(i-1 >= 0 && dp[i-1][j] == dp[i][j]){
                ans = str1.charAt(i) + ans;
                i--;
            }
            else if(dp[i][j] == 0) break;
            else{
                inter = str2.charAt(j) + inter;
                ans = str2.charAt(j) + ans;
                i--; j--;
            }
            lasti = i; lastj = j;
        }

        // System.out.println(lasti + " " + lastj + " " + inter + " " + ans);
        for(i=lasti; i>=0; i--){
            if(dp[i][lastj >= 0 ? lastj : 0] == 0) ans = str1.charAt(i) + ans;
        }

        for(i=lastj; i>=0; i--){
            ans = str2.charAt(i) + ans;
        }

        // for(i=0; i<sz1; i++){
        //     for(j=0; j<sz2; j++){
        //         System.out.print(dp[i][j] + ", ");
        //     }
        //     System.out.println();
        // }

        return ans;
    }
}