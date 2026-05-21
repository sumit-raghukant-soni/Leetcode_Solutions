class Solution {
    public boolean isNumber(String s) {
        int sz = s.length();
        boolean dFlg = false;
        int eInd = Integer.MIN_VALUE, dCnt = 0, d2Cnt = 0; 

        if(sz == 1 && !Character.isDigit(s.charAt(0))) return false;

        for(int i=0; i<sz; i++){
            char ch = s.charAt(i);
            // System.out.println(ch);
            // System.out.println("e " + eInd + " d " + dFlg);
            if(i == 1 && (s.charAt(i-1) == '-' || s.charAt(i-1) == '+') && !Character.isDigit(ch) && ch != '.') {
                return false;
            }
            else if(i == sz-1 && (ch == '-' || ch == '+' || ch == 'e' || ch == 'E')) {
                return false;
            }
            if(ch == 'e' || ch == 'E'){
                if(i == 0 || eInd != Integer.MIN_VALUE || dCnt == 0) return false;
                else eInd = i;
            }
            else if(ch == '-' || ch == '+'){
                if(i != 0 && eInd != i-1) return false;
            }
            else if(ch == '.') {
                if(dFlg || eInd != Integer.MIN_VALUE) return false;
                dFlg = true;
            }
            else if(!Character.isDigit(ch)) return false;
            else {
                if(eInd != Integer.MIN_VALUE) d2Cnt++;
                else dCnt++;
            }
        }


        return dCnt > 0 && (eInd == Integer.MIN_VALUE || d2Cnt > 0);
    }

    
}