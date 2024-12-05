class Solution {
    public boolean canChange(String start, String target) {
        int sz = start.length();
        int r1 = 0, l1 = 0;
        for(int i=0; i<sz; i++){
            if(start.charAt(i) == 'R') r1++;
            if(target.charAt(i) == 'R') r1--;
            if((r1 < 0) || ((start.charAt(i) == 'L' || target.charAt(i) == 'L') && r1 != 0)){
                return false;
            }

            if(start.charAt(i) == 'L') l1--;
            if(target.charAt(i) == 'L') l1++;
            if((l1 < 0) || ((start.charAt(i) == 'R' || target.charAt(i) == 'R') && l1 != 0)){
                return false;
            }
        }

        if(l1 != 0 || r1 != 0) return false;
        return true;
    }
}