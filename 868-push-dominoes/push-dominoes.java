class Solution {
    public String pushDominoes(String dominoes) {
        int sz = dominoes.length();
        String ans = "";
        int arr[] = new int[sz], left[] = new int[sz], right[] = new int[sz];
        int flg = 0;

        for(int i=0; i<sz; i++){
            if(dominoes.charAt(i) == 'L') arr[i] = 1;
            else if(dominoes.charAt(i) == 'R') arr[i] = 2;
            else arr[i] = 0;
        }
        
        for(int i=0; i<sz; i++){
            if(arr[i] == 2){
                flg = 1;
            }
            else if(arr[i] != 0) flg = 0;
            if(flg > 0){
                if(arr[i] == 0) right[i] = flg++;
            }
        }

        flg = 0;
        for(int i=sz-1; i>=0; i--){
            if(arr[i] == 1){
                flg = 1;
            }
            else if(arr[i] != 0) flg = 0;
            if(flg > 0){
                if(arr[i] == 0) left[i] = flg++;
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