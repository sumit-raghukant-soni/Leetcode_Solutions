class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int sz = seq.length(), cnt = 0; 
        int ans[] = new int[sz];
        char ch;

        for(int i=0; i<sz; i++) {
            ch = seq.charAt(i);
            if(ch == ')')  cnt--;
            if((cnt&1) == 1) {
                ans[i] = 1;
            }
            else ans[i] = 0;
            if(ch == '(')  cnt++;
        }

        return ans;
    }
}