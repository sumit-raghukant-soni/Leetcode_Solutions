class Solution {
public:
    int n;
    int dp[2][101][101];
    int solve(int person,int ind,int m,vector<int>& piles){
        if(ind>=n) return 0;
        if(dp[person][ind][m]!=-1) return dp[person][ind][m];

        int result= (person==1)?-1:1e9;
        int stones=0;
        for(int i=1;i<=min(2*m,n-ind);i++){
            stones+= piles[ind+i-1];
            if(person==1){
                result= max(result,stones+ solve(0,ind+i,max(m,i),piles));
            }
            else{
                result= min(result, solve(1,ind+i,max(m,i),piles));
            }
        }
        return dp[person][ind][m]=result;
    }
    int stoneGameII(vector<int>& piles) {
        n= piles.size();
        memset(dp,-1,sizeof(dp));
        return solve(1,0,1,piles);
    }
};