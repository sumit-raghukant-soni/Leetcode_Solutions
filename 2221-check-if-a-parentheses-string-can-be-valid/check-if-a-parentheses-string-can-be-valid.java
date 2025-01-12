class Solution {
    public boolean canBeValid(String s, String locked) {
        int sz = s.length(), f = 0, open = 0;
        if((sz%2) == 1) return false;

        for(int i=0; i<sz; i++){
            if(locked.charAt(i) == '0') f++;
            else if(s.charAt(i) == '('){
                open++;
            }
            else{
                if(open > 0) open--;
                else if(f > 0) f--;
                else return false;
            }
        }

        int remaining = 0;
        for(int i=sz-1; i>=0; i--){
            if(locked.charAt(i) == '0'){
                remaining--; f--;
            }
            else if(s.charAt(i) == '('){
                remaining++;
                open--;
            }
            else remaining--;

            if(remaining > 0) return false;
            if(f == 0 && open == 0) break;
        }

        return open <= 0;
    }
}