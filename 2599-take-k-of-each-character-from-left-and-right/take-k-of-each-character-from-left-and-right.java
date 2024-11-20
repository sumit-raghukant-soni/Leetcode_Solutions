class Solution {
    public int takeCharacters(String s, int k) {
        int sz = s.length(), ta = 0, tb = 0, tc = 0, ea, eb, ec, ans = 0;

        for(int i=0; i<sz; i++){
            if(s.charAt(i) == 'a') ta++;
            else if(s.charAt(i) == 'b') tb++;
            else tc++;
        }

        ea = ta - k; eb = tb - k; ec = tc - k;
        if(ea < 0 || eb < 0 || ec < 0) return -1;

        int tmp1 = 0, tmp2 = 0, tmp3 = 0, j=0;
        for(int i=0; i<sz; i++){
            if(s.charAt(i) == 'a') tmp1++;
            else if(s.charAt(i) == 'b') tmp2++;
            else tmp3++;
            if(tmp1 <= ea && tmp2 <= eb && tmp3 <= ec){
                ans = Math.max(ans, i-j+1);
            }
            else{
                while(j <= i && tmp1 > ea || tmp2 > eb || tmp3 > ec){
                    if(s.charAt(j) == 'a') tmp1--;
                    else if(s.charAt(j) == 'b') tmp2--;
                    else tmp3--;
                    j++;
                }
            }
        }

        return sz-ans;
    }
}