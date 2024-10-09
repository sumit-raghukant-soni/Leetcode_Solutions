class Solution {
    public int minAddToMakeValid(String str) {
        int s=0, e=0, sz = str.length();

        for(int i=0; i<sz; i++){
            if(str.charAt(i) == '('){
                s++;
            }
            else{
                if(s > 0){
                    s--;
                }
                else e++;
            }
        }

        return s + e;
    }
}