class Solution {
    public boolean checkValidString(String s) {
        int sz = s.length(), surplus = 0, cnt = 0;

        for(int i=0; i<sz; i++){
            if(s.charAt(i) == '('){
                cnt++;
            }
            else if(s.charAt(i) == '*') surplus++;
            else{
                if(cnt > 0) cnt--;
                else if(surplus > 0) surplus--;
                else return false;
            }
            // System.out.print(cnt + ":" + surplus + ",");
        }
        
        cnt = 0; surplus = 0;
        for(int i=sz-1; i>=0; i--){
            if(s.charAt(i) == '('){
                if(cnt > 0) cnt--;
                else if(surplus > 0) surplus--;
                else return false;
            }
            else if(s.charAt(i) == ')') cnt++;
            else surplus++;
        }

        return true;
    }
}