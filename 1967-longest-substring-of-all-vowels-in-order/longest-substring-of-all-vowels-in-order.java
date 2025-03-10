class Solution {
    public int longestBeautifulSubstring(String word) {
        int sz = word.length(), ans = 0, cnt = 0;
        int st = 0;
        int vwl[] = {'a', 'e', 'i', 'o', 'u'}, k = 0;

        for(int i=0; i<sz; i++){
            if(word.charAt(i) == vwl[k]) st++;
            else if(st > 0 && k+1 < 5 && word.charAt(i) == vwl[k+1]){
                st++;
                if(k < 4) k++;
            }
            else{
                if(word.charAt(i) == vwl[0]) st = 1;
                else st = 0;
                k = 0;
            }
            if(k == 4) ans = Math.max(st, ans);
        }

        return ans;
    }
}