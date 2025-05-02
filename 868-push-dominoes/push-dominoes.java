class Solution {
    public String pushDominoes(String dominoes) {
        int sz = dominoes.length(), flg1 = 0, flg2 = 0;
        int left[] = new int[sz], right[] = new int[sz];
        char ch1, ch2;
        String ans = "";

        for(int i=0, j=sz-1; i<sz; i++, j--){
            ch1 = dominoes.charAt(i); 
            ch2 = dominoes.charAt(j);
            if(ch1 == 'R'){
                flg1 = 1;
            }
            else if(ch1 != '.') flg1 = 0;
            if(ch2 == 'L'){
                flg2 = 1;
            }
            else if(ch2 != '.') flg2 = 0;
            if(flg1 > 0 && ch1 == '.'){
                right[i] = flg1++;
            }
            if(flg2 > 0 && ch2 == '.'){
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