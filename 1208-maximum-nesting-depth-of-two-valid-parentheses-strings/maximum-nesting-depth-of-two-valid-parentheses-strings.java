class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int sz = seq.length(), oCnt = 0, cCnt = 0;
        int ans[] = new int[sz];

        for(int i=0; i<sz; i++){
            if(seq.charAt(i) == '('){
                oCnt++;
                if(oCnt%2 == 0) ans[i] = 1;
            }
            else{
                cCnt++;
                if(cCnt%2 == 0) ans[i] = 1;
            } 
            
        }

        return ans;
    }
}