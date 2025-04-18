class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int sz = points.length, cnt = 0;
        double[][] dp = new double[sz][sz];

        for(int i=0; i<sz; i++){
            for(int j=0; j<sz; j++){
                dp[i][j] = ( Math.sqrt( Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2) ) );
            }
        }

        for(int i=0; i<sz; i++){
            for(int j=0; j<sz; j++){
                double sum = dp[i][j];
                for(int k=0; k<sz; k++){
                    if(k != i && dp[j][k] == sum) cnt++;
                }
            }
        }

        return cnt;
    }
}