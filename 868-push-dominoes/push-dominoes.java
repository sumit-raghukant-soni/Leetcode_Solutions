class Solution {
    public String pushDominoes(String dominoes) {
        int sz = dominoes.length(), flg1 = 0, flg2 = 0;
        String ans = "";
        int left[] = new int[sz], right[] = new int[sz];

        for(int i=0, j=sz-1; i<sz; i++, j--){
            if(dominoes.charAt(i) == 'R'){
                flg1 = 1;
            }
            else if(dominoes.charAt(i) != '.') flg1 = 0;
            if(dominoes.charAt(j) == 'L'){
                flg2 = 1;
            }
            else if(dominoes.charAt(j) != '.') flg2 = 0;
            if(flg1 > 0 && dominoes.charAt(i) == '.'){
                right[i] = flg1++;
            }
            if(flg2 > 0 && dominoes.charAt(j) == '.'){
                left[j] = flg2++;
            }
        }

        for(int i=0; i<sz; i++){
            if(left[i] != 0 && right[i] != 0){
                if(left[i] > right[i]) ans += "R";
                else if(left[i] < right[i]) ans += "L";
                else ans += ".";
            }
            else if(left[i] != 0) ans += "L";
            else if(right[i] != 0) ans += "R";
            else ans += dominoes.charAt(i);
        }

        return ans;
    }
}