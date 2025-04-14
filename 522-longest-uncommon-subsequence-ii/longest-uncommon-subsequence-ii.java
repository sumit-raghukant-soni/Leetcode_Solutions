class Solution {
    public int findLUSlength(String[] strs) {
        int sz = strs.length, ans = -1;
        boolean flg;

        for(int i=0; i<sz; i++){
            flg = true;
            for(int j=0; j<sz; j++){
                if(i != j && CheckCommon(strs[j], strs[i])){
                    flg = false;
                    break;
                }
            }
            if(flg) ans = Math.max(ans, strs[i].length());
        }

        return ans;
    }

    private boolean CheckCommon(String a, String b){
        int sz1 = a.length(), sz2 = b.length();
        int j = 0;

        for(int i=0; i<sz1; i++){
            if(j < sz2 && a.charAt(i) == b.charAt(j)) j++;
        }

        if(j == sz2) return true;
        return false;
    }
}