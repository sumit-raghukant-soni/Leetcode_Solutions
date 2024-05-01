class Solution {
public:
int len;
    int solve(int n,int st,int end,vector<int>&cuts,vector<vector<int>>&dp)
{   
    if(st>=end)return 0;
    
    if(dp[st][end]!=0)return dp[st][end];
    int ans=INT_MAX;

    for(int i=st;i<end;i++){

        int le= st==0?0:cuts[st-1];
        int re= end==cuts.size()?len:cuts[end];

        int cost=re-le;
        int left=solve(le,st,i,cuts,dp);
        int right=solve(re,i+1,end,cuts,dp);

        int tempans=left+right+cost;
        ans=min(ans,tempans);
    }

    return dp[st][end]=ans;

}
    int minCost(int n, vector<int>& cuts) {
        int sz=cuts.size();
        vector<vector<int>>dp(sz+1,vector<int>(sz+1,0));
        len=n;
        sort(cuts.begin(),cuts.end());
        return solve(n,0,sz,cuts,dp);
    }
};