class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean nonprimes[] = new boolean[right+1];
        int ans[] = new int[2];
        ans[0] = -1; ans[1] = -1;

        nonprimes[1] = true;
        for(int i=2; i<=right; i++){
            if(nonprimes[i] == false){
                for(int j=i+i; j<=right; j+=i){
                    nonprimes[j] = true;
                }
            }
        }

        int dis = Integer.MAX_VALUE, curr_dis = 0, a = -1;
        for(int i=left; i<=right; i++){
            if(nonprimes[i] == false){
                if(a == -1){
                    a = i;
                    curr_dis = -1;
                } 
                else{
                    if(curr_dis < dis){
                        dis = curr_dis;
                        ans[0] = a; ans[1] = i;
                    }
                    curr_dis = -1;
                    a = i;
                }
            }
            curr_dis++;
        }
        
        return ans;
    }
}