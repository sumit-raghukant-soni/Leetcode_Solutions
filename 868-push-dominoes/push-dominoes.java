class Solution {
    public String pushDominoes(String dominoes) {
        int sz = dominoes.length(), flg1 = 0, flg2 = 0;
        int arr[] = new int[sz];
        char ch1, ch2;
        StringBuilder ans = new StringBuilder("");

        for(int i=0, j=sz-1; i<sz; i++, j--){
            ch1 = dominoes.charAt(i); 
            ch2 = dominoes.charAt(j);
            if(ch1 == 'R'){
                flg1 = sz;
            }
            else if(ch1 != '.') flg1 = 0;
            else arr[i] += flg1 > 0 ? flg1-- : 0;
            
            if(ch2 == 'L'){
                flg2 = -sz;
            }
            else if(ch2 != '.') flg2 = 0;
            else arr[j] += flg2 < 0 ? flg2++ : 0;
        }

        for(int i=0; i<sz; i++){
            if(arr[i] != 0){
                if(arr[i] > 0) ans.append("R");
                else if(arr[i] < 0) ans.append("L");
                else ans.append(".");
            }
            else ans.append(dominoes.charAt(i));
        }

        return ans.toString();
    }
}