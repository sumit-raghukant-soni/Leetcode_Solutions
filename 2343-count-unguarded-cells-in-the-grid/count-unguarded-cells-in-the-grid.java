class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        String dp[][] = new String[m][n];
        int ans = 0;

        for(int i=0; i<guards.length; i++){
            dp[guards[i][0]][guards[i][1]] = "G";
        }

        for(int i=0; i<walls.length; i++){
            dp[walls[i][0]][walls[i][1]] = "W";
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(j-1 >= 0 && (dp[i][j] == null || dp[i][j].compareTo("W") != 0 && dp[i][j].equals("G") == false) && (dp[i][j-1] == "G" || dp[i][j-1] == "R")){
                    dp[i][j] = "R";
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=n-1; j>=0; j--){
                if(j+1 < n && (dp[i][j] == null || dp[i][j].compareTo("W") != 0 && dp[i][j].equals("G") == false) && (dp[i][j+1] == "G" || dp[i][j+1] == "L")){
                    dp[i][j] = "L";
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(j-1 >= 0 && (dp[j][i] == null || dp[j][i].equals("W") == false && dp[j][i].equals("G") == false) && (dp[j-1][i] == "G" || dp[j-1][i] == "T")){
                    dp[j][i] = "T";
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=m-1; j>=0; j--){
                if(j+1 < m && (dp[j][i] == null || dp[j][i].equals("W") == false && dp[j][i].equals("G") == false) && (dp[j+1][i] == "G" || dp[j+1][i] == "B")){
                    dp[j][i] = "B";
                }
            }
        }


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dp[i][j] == null) ans++;
                // System.out.print(dp[i][j] + " ");
            }
            // System.out.println();
        }

        return ans;
    }
}