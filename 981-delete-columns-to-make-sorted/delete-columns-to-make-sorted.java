class Solution {
    public int minDeletionSize(String[] strs) {
        int sz = strs.length, sz2 = strs[0].length(), ans = 0;
        char cols[] = new char[sz2];
        boolean flgs[] = new boolean[sz2];

        for(int i=0; i<sz2; i++){
            cols[i] = strs[0].charAt(i);
        }

        for(int i=1; i<sz; i++){
            for(int j=0; j<sz2; j++){
                // System.out.println(strs[i].charAt(j) + ">" + cols[j]);
                if(strs[i].charAt(j) < cols[j]){
                    flgs[j] = true;
                }
                cols[j] = strs[i].charAt(j);
            }
        }

        for(boolean val : flgs){
            ans += val ? 1 : 0;
        }

        return ans;
    }
}