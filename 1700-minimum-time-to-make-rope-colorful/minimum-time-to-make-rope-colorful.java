class Solution {
    public int minCost(String colors, int[] neededTime) {
        int sz = colors.length(), ans = 0;
        int sum = 0, maxi = 0;

        for(int i=0; i<sz; i++){
            if(i-1 >= 0 && colors.charAt(i) == colors.charAt(i-1)){
                sum += neededTime[i];
                maxi = maxi > neededTime[i] ? maxi : neededTime[i];
            }
            // else if(i-1 >= 0 && colors.charAt(i) != colors.charAt(i-1))
            else{
                if(maxi > 0){
                    ans += sum - maxi;
                }
                maxi = sum = neededTime[i];
            }
            // System.out.println(sum + " " + maxi + " " + ans);
        }
        
        if(maxi > 0) ans += sum - maxi;
        return ans;
    }
}